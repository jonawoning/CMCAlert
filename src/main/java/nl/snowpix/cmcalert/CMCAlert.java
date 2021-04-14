package nl.snowpix.cmcalert;

import nl.snowpix.cmcalert.system.Config;
import nl.snowpix.cmcalert.system.Registerer;
import nl.snowpix.cmcalert.system.SystemColors;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class CMCAlert extends JavaPlugin {

    public static CMCAlert instance;
    public FileConfiguration c;
    private Config config;

    @Override
    public void onEnable() {
        instance = this;
        c = getConfig();
        config = new Config();

        config.ReloadConfig();

        Registerer.RegisterEvents();

        System.out.println(SystemColors.TEXT_YELLOW + "[CMC] " + SystemColors.TEXT_GREEN + "The plugin is successfully enabled." + SystemColors.TEXT_RESET);

    }

    @Override
    public void onDisable() {

        System.out.println(SystemColors.TEXT_YELLOW + "[CMC] " + SystemColors.TEXT_GREEN + "The plugin is successfully disabled." + SystemColors.TEXT_RESET);

    }

    public Config getCConfig(){
        return config;
    }

}
