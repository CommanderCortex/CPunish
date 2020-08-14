package ctx.cpunish.Messages;
import org.bukkit.ChatColor;

public class GlobalMSGS {
    public String PluginPrefix = ChatColor.translateAlternateColorCodes('&', "&bC-Punish> ");
    public String noPerm = PluginPrefix + ChatColor.translateAlternateColorCodes('&', "&9Error! You Do Not Have Permission to Execute this Command");
    public String Loaded0 = PluginPrefix + "C-Perms Has Loaded With 0 Errors";
    public String GUINAME = ChatColor.translateAlternateColorCodes('&', "&9Online Players:");
    public String BANOPT = ChatColor.translateAlternateColorCodes('&', "&9Punish Options:");
    public String Mute1d = ChatColor.translateAlternateColorCodes('&', "&93 Day Mute For @");
    public String PermMute = ChatColor.translateAlternateColorCodes('&', "&9Perm Mute @");
    public String TempBan = ChatColor.translateAlternateColorCodes('&', "&93 Day Temp Ban For @");
    public String PermBan = ChatColor.translateAlternateColorCodes('&', "&9Perm Ban For @");
    public String PermBanMSG = PluginPrefix + ChatColor.translateAlternateColorCodes('&', "Successfully Baned @");
}
