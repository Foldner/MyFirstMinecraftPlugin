package me.foldner.joinmessage;

import me.foldner.joinmessage.commands.PlayerBonkCommand;
import me.foldner.joinmessage.commands.SetBlockCommand;
import me.foldner.joinmessage.events.PlayerListener;
import org.mineacademy.fo.plugin.SimplePlugin;

public final class JoinMessage extends SimplePlugin {

    @Override
    protected void onPluginStart() {
        registerEvents(new PlayerListener());

        registerCommand(new PlayerBonkCommand("bonk"));
        registerCommand(new SetBlockCommand("setblock|sb"));
    }
}
