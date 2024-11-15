package mc.tiktok;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Giant;
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
                        Zombie zombie = (Zombie) p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
                        zombie.setCustomName(e.getPlayer().getName()); //change to tiktok user
                        zombie.setCustomNameVisible(true);
                    break;

                    case "giant":
                        Giant giant = (Giant) p.getWorld().spawnEntity(p.getLocation(), EntityType.GIANT);
                        giant.setCustomName(e.getPlayer().getName()); //change to tiktok user
                        giant.setCustomNameVisible(true);
                    break;

                    case "tnt":
                        p.getWorld().spawnEntity(p.getLocation(), EntityType.TNT);
                    break;

                    case "float":
                        p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 50, 1));
                    break;

                    case "fatigue":
                        p.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 200, 2));
                    break;

                    case "rtp":
                        double rd1 = -1000 + (Math.random() * 2000);
                        double rd2 = -1000 + (Math.random() * 2000);
                        double y = 255;
                        Location l = new Location(p.getWorld(), rd1, y, rd2);
                        while (l.getBlock().getType().equals(Material.AIR) || l.getBlock().getType().equals(null)) {
                            y=y-1;
                            l = new Location(p.getWorld(), rd1, y, rd2);
                        }
                        l = new Location(p.getWorld(), rd1, y+1, rd2);
                        p.teleport(l);
                    break;

                    case "food":
                        p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 1));
                    break;

            default:
                p.sendMessage("nice chat");
        }
    }
}
