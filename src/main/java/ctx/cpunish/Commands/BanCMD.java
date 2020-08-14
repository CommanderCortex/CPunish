package ctx.cpunish.Commands;

import ctx.cpunish.CPunish;
import ctx.cpunish.Messages.GlobalMSGS;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCMD implements CommandExecutor {
    GlobalMSGS globalMSGS = new GlobalMSGS();
    CPunish cPunish;
    public BanCMD(CPunish cPunish) {
        this.cPunish = cPunish;
    }
    public String reason;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        reason = args[1];
        if(!(sender instanceof Player)){ sender.sendMessage("Player Command Only"); return true; }
        Player player = (Player) sender;
        if(!player.hasPermission("Cortex.Punish.Use")){player.sendMessage(globalMSGS.noPerm); return true;}
        if(args.length != 1){ player.sendMessage(""); return true;}
        cPunish.openGui(player);
        return true;
    }
}
