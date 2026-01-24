package hu.nephesis.simplecommanddisable;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    private static final String BYPASS_ALL = "commanddisabler.bypass";
    private final Set<String> blockedCommands = new HashSet<>();
    private String denyMessage;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadSettings();
        getServer().getPluginManager().registerEvents(this, this);
    }

    private void loadSettings() {
        blockedCommands.clear();
        List<String> commands = getConfig().getStringList("blocked-commands");
        for (String command : commands) {
            if (command == null) {
                continue;
            }
            String normalized = command.trim().toLowerCase(Locale.ROOT);
            if (!normalized.isEmpty()) {
                blockedCommands.add(normalized);
            }
        }
        String rawMessage = getConfig().getString("deny-message", "&cYou do not have permission to use that command.");
        denyMessage = ChatColor.translateAlternateColorCodes('&', rawMessage);
    }

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission(BYPASS_ALL)) {
            return;
        }
        String message = event.getMessage();
        if (message == null || message.length() <= 1) {
            return;
        }
        String label = message.substring(1).split(" ", 2)[0].toLowerCase(Locale.ROOT);
        if (blockedCommands.contains(label) && !player.hasPermission(BYPASS_ALL + "." + label)) {
            event.setCancelled(true);
            if (!denyMessage.isEmpty()) {
                player.sendMessage(denyMessage);
            }
        }
    }
}
