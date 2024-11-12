package mc.tiktok;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class MyListener implements Listener{

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player p = e.getPlayer();
        switch (e.getMessage()) {
            case "blind":
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 50, 255));
            break;

            case "drop":
                
            break;

            default:
                p.sendMessage("nice chat");
        }
    }
}
