package me.foldner.joinmessage.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class PlayerBonkCommand extends SimpleCommand {


    public PlayerBonkCommand(String label) {
        super(label);
    }

    @Override
    protected void onCommand() {
        for(Player player : Bukkit.getServer().getOnlinePlayers()) {
            //if (player.getName().equalsIgnoreCase("Foldner")) continue;

            Common.tell(player, "<Horny patrol> *BONK*");
            player.damage(1);
            player.getInventory().setItemInMainHand(ItemCreator.of(
                    CompMaterial.WOODEN_SWORD, "Bonk smb else", "Your bonk weapon")
                    .build().make());
        }
    }
}
