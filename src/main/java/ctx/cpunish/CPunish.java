package ctx.cpunish;

import ctx.cpunish.Commands.BanCMD;
import ctx.cpunish.Events.PunishInventoryEvent;
import ctx.cpunish.Messages.GlobalMSGS;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class CPunish extends JavaPlugin {
    GlobalMSGS globalMSGS = new GlobalMSGS();
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PunishInventoryEvent(this), this);
        getBanCommand();
        Bukkit.broadcastMessage(globalMSGS.Loaded0);
    }
    public void openGui(Player player){
        ArrayList<Player> players = new ArrayList<>(player.getServer().getOnlinePlayers());
        Inventory punishGUI = Bukkit.createInventory(player, 45, globalMSGS.GUINAME);
        //For Every Player Add Head, Name & Custom Lore
        for(int i=0;i<players.size();i++){
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta meta = playerHead.getItemMeta(); meta.setDisplayName(players.get(i).getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add("Allowed Flight: "+players.get(i).getAllowFlight());
            lore.add("Player OP: "+players.get(i).isOp());
            meta.setLore(lore); playerHead.setItemMeta(meta);
            punishGUI.addItem(playerHead);
        }
        player.openInventory(punishGUI);
    }
    public void playerGui(Player player, Player target){
        Inventory playerMenu = Bukkit.createInventory(player, 9, globalMSGS.BANOPT);

        //Back Menu
        ItemStack BackMenu = new ItemStack(Material.GHAST_TEAR, 1);
        ItemMeta BackMenuMeta = BackMenu.getItemMeta();
        BackMenuMeta.setDisplayName(ChatColor.DARK_GRAY + "Return To Player List");
        BackMenu.setItemMeta(BackMenuMeta);
        playerMenu.setItem(0, BackMenu);

        //Temp Mute Option
        ItemStack Mute1day = new ItemStack(Material.PAPER, 1);
        ItemMeta mute = Mute1day.getItemMeta();
        mute.setDisplayName(globalMSGS.Mute1d + target);
        Mute1day.setItemMeta(mute);
        playerMenu.setItem(1, Mute1day);

        //Perm Mute Option
        ItemStack MutePerm = new ItemStack(Material.BOOK, 1);
        ItemMeta PermMute = MutePerm.getItemMeta();
        PermMute.setDisplayName(globalMSGS.PermMute + target);
        MutePerm.setItemMeta(PermMute);
        playerMenu.setItem(2, MutePerm);

        //Temp Ban Option
        ItemStack tempBan = new ItemStack(Material.RED_DYE, 1);
        ItemMeta tempBanMeta = tempBan.getItemMeta();
        tempBanMeta.setDisplayName(globalMSGS.TempBan + target);
        tempBan.setItemMeta(tempBanMeta);
        playerMenu.setItem(3, tempBan);

        //Perm Ban Option
        ItemStack permBan = new ItemStack(Material.REDSTONE_BLOCK, 1);
        ItemMeta permBanMeta = permBan.getItemMeta();
        permBanMeta.setDisplayName(globalMSGS.PermBan + target);
        permBan.setItemMeta(permBanMeta);
        playerMenu.setItem(4, permBan);

        player.openInventory(playerMenu);

    }


    public void getBanCommand(){getCommand("punish").setExecutor(new BanCMD(this));}
}
