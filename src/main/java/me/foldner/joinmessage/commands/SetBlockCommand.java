package me.foldner.joinmessage.commands;

import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.remain.CompMaterial;

public class SetBlockCommand extends SimpleCommand {

    public SetBlockCommand(String label) {
        super(label);
    }

    @Override
    protected void onCommand() {
        checkConsole();
        if (args.length < 1) returnTell("&cНеверная команда: /setblock <material>");

        if (getPlayer().getTargetBlock(4) == null) returnTell("&cНа блок наведись");

        CompMaterial compMaterial = CompMaterial.fromString(args[0]);
        if (compMaterial == null) returnTell("&cid блока неверный");

        getPlayer().getWorld().getBlockAt(getPlayer().getTargetBlock(4).getLocation()).setType(compMaterial.toMaterial());
    }
}
