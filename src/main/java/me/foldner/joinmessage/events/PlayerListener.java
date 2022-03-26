package me.foldner.joinmessage.events;

import com.sk89q.worldguard.bukkit.event.entity.DamageEntityEvent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mineacademy.fo.Common;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        //Common.broadcast("Hi newbie &a" + event.getPlayer().getName());
        Common.broadcast(("<" + event.getPlayer().getName() + "> Hello world!"));
        Common.broadcast(("<" + event.getPlayer().getWorld().getName() + "> " + "Hi bro &a" +
                event.getPlayer().getName() + " &fWhat's up?"));
    }

    @EventHandler
    public void onPlayerHitsAdmin(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player)) return;

        if (!(event.getEntity().getName().equalsIgnoreCase("foldner"))) return;

        if (event.getDamager() instanceof Arrow)
        {
            Projectile arrow = (Projectile) event.getDamager();

            if (!(arrow.getShooter() instanceof Player)) return;

            Common.tell((Player)arrow.getShooter(), "&cты не можешь подстрелить админа");
        }

        Common.tell(event.getDamager(), "&cТы не можешь ударить админа");

        event.setCancelled(true);
    }
}
