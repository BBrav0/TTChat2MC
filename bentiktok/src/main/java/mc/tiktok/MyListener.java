package mc.tiktok;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class MyListener implements Listener{

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player p = e.getPlayer();
        switch (e.getMessage()) {
            case "blind":
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 75, 255));
            break;

            case "drop":
                ItemStack i = p.getInventory().getItemInMainHand();
                if (i!=null && i.getAmount()>0) {
                    p.getWorld().dropItemNaturally(p.getLocation(),i.clone()).setPickupDelay(40);;
                    p.getInventory().setItemInMainHand(null);
                }
            break;

            case "zombie":
                p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
            break;

            case "food":
                p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 1));
            break;

            default:
                p.sendMessage("nice chat");
        }
    }
}
