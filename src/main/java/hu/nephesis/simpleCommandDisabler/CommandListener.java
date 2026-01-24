package hu.nephesis.simpleCommandDisabler;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {

    private final Main plugin;

    public CommandListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (event.isCancelled()) {
            return;
        }
        Player player = event.getPlayer();
        if (player.hasPermission("commanddisabler.bypass")) {
            return;
        }

        String message = event.getMessage();
        String[] parts = message.split(" ");
        String command = parts[0].substring(1);

        for (String blocked : plugin.getConfig().getStringList("blocked-commands")) {
            if (blocked.equalsIgnoreCase(command) ||
               (blocked.startsWith("/") && blocked.substring(1).equalsIgnoreCase(command))) {

                event.setCancelled(true);
                String blockedMessage = plugin.getConfig().getString("blocked-message");
                if (blockedMessage != null && !blockedMessage.isEmpty()) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', blockedMessage));
                }
                return;
            }
        }
    }
}
