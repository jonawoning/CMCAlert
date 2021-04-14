package nl.snowpix.cmcalert.commands;

import nl.snowpix.cmcalert.CMCAlert;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class Broadcast implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission(CMCAlert.instance.getCConfig().Broadcast_Permission)){
            if (args.length > 0){
                String message = "";
                for (String part : args) {
                    if (message != "") message += " ";
                    message += part;
                }
                List<String> broadcastmessage = CMCAlert.instance.c.getStringList("BroadcastMessage");
                for(String looped : broadcastmessage){
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', looped.replace("%message%", message).replace("%prefix%", CMCAlert.instance.getCConfig().Prefix)));
                }
            }else{
                sender.sendMessage(CMCAlert.instance.getCConfig().Prefix + "Usage: /alert (message)");
            }
        }else{
            sender.sendMessage(CMCAlert.instance.getCConfig().Prefix + CMCAlert.instance.getCConfig().No_Permission);
        }
        return false;
    }
}
