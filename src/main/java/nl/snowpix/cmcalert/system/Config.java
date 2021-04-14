package nl.snowpix.cmcalert.system;

import nl.snowpix.cmcalert.CMCAlert;
import org.bukkit.ChatColor;

public class Config {

    public String Prefix;
    public String BroadcastMessage;
    public String Broadcast_Permission;
    public String No_Permission;

    public void ReloadConfig(){
        ReloadConfigYML();
        CMCAlert.instance.reloadConfig();
        CMCAlert.instance.getConfig().options().copyDefaults();
        CMCAlert.instance.saveDefaultConfig();
    }

    private void ReloadConfigYML(){
        Prefix = ChatColor.translateAlternateColorCodes('&', CMCAlert.instance.c.getString("Prefix"));
        BroadcastMessage = ChatColor.translateAlternateColorCodes('&', String.valueOf(CMCAlert.instance.c.getStringList("BroadcastMessage")));
        Broadcast_Permission = CMCAlert.instance.c.getString("Broadcast_Permission");
        No_Permission = ChatColor.translateAlternateColorCodes('&', CMCAlert.instance.c.getString("No_Permission"));
    }

}
