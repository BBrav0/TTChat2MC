package mc.tiktok;

import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
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
                Creeper zombie = (Creeper) p.getWorld().spawnEntity(p.getLocation(), EntityType.CREEPER);
                zombie.setCustomName(p.getName()); //change to tiktok user
                zombie.setCustomNameVisible(true);
            break;

            case "tnt":
                p.getWorld().spawnEntity(p.getLocation(), EntityType.TNT);
            break;

            case "zombie100": //rose
                Zombie z;
                for (int tempintzombie = 0; tempintzombie<100; tempintzombie++) {
                z = (Zombie) p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
                z.setCustomName(p.getName()); //change to tiktok user
                z.setCustomNameVisible(true);
            }
            break;

            case "float":
                p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 75, 1));
            break;

            case "food":
                p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 1));
            break;

            default:
                p.sendMessage("nice chat");
        }
    }
}
