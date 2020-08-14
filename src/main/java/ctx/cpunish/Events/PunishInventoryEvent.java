package ctx.cpunish.Events;

import ctx.cpunish.CPunish;
import ctx.cpunish.Commands.BanCMD;
import ctx.cpunish.Messages.GlobalMSGS;
import jdk.nashorn.internal.objects.Global;
import org.bukkit.BanList;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PunishInventoryEvent implements Listener {
    CPunish cPunish;
    public PunishInventoryEvent(CPunish cPunish) { this.cPunish = cPunish; }
    GlobalMSGS globalMSGS = new GlobalMSGS();
    BanCMD banCMD;
    public PunishInventoryEvent(BanCMD banCMD) { this.banCMD = banCMD; }
    String reason = banCMD.reason;
    @EventHandler
    public void onMenuClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        if(e.getClickedInventory().contains(Material.PLAYER_HEAD)){
            if(e.getCurrentItem().getType() == Material.PLAYER_HEAD){
                Player target = player.getServer().getPlayer(e.getCurrentItem().getItemMeta().getDisplayName());
                    cPunish.playerGui(player, target);
                    switch(e.getCurrentItem().getType()){
                        case GHAST_TEAR:
                            cPunish.openGui(player);
                            break;
                        case REDSTONE_BLOCK:
                            String name = e.getCurrentItem().getItemMeta().getDisplayName();
                            player.getServer().getBanList(BanList.Type.NAME).addBan(name, reason, null, player.getDisplayName());
                            player.sendMessage(globalMSGS.PermBanMSG + target);
                            break;
                    }
            }
        }
        e.setCancelled(true);
    }


}
