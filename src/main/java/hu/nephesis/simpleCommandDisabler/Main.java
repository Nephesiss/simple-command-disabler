package hu.nephesis.simpleCommandDisabler;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new CommandListener(this), this);
        getLogger().info("SimpleCommandDisabler has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("SimpleCommandDisabler has been disabled!");
    }
}
