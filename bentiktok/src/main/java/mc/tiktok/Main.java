package mc.tiktok;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.destroystokyo.paper.Title;

import io.github.jwdeveloper.tiktok.TikTokLive;

public class Main extends JavaPlugin {

    public static final String BLACK = "§0";
    public static final String DARK_BLUE = "§1";
    public static final String DARK_GREEN = "§2";
    public static final String DARK_AQUA = "§3";
    public static final String DARK_RED = "§4";
    public static final String DARK_PURPLE = "§5";
    public static final String GOLD = "§6";
    public static final String GRAY = "§7";
    public static final String DARK_GRAY = "§8";
    public static final String BLUE = "§9";
    public static final String GREEN = "§a";
    public static final String AQUA = "§b";
    public static final String RED = "§c";
    public static final String LIGHT_PURPLE = "§d";
    public static final String YELLOW = "§e";
    public static final String WHITE = "§f";

    @Override
    public void onLoad() {

    }

    @SuppressWarnings("deprecation")
    @Override
    public void onEnable() {

        getLogger().info("TikTok Plugin Enabled.");


        TikTokLive.newClient("bumsdito").onComment((liveClient, e) -> {
            

            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(Main.GREEN+e.getUser().getName()+": "+Main.GRAY+e.getText());
                switch (e.getText()) {
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
                zombie.setCustomName(e.getUser().getName()); //change to tiktok user
                zombie.setCustomNameVisible(true);
            break;

            case "tnt":
                p.getWorld().spawnEntity(p.getLocation(), EntityType.TNT);
            break;

            case "float":
                p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 75, 1));
            break;

            case "food":
                p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 1));
            break;
                }


            }
            
            

        }).onGift((liveClient, tikTokGiftEvent) -> {
            String message = switch(tikTokGiftEvent.getGift()) {
                case ROSE -> "ROSE!";
                case GG -> "GOOD GAME";
                case TIKTOK -> "Ye";
                case CORGI -> "Nice gift";
                default -> "Thank you for " + event.getGift().getName();
            };
            
        }).onLike((liveClient, e) -> {

            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(Main.GREEN+e.getUser().getName()+Main.RED+" has liked the LIVE <3");
            }

        }).onJoin((liveClient, e) -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(Main.GREEN+e.getUser().getName()+Main.AQUA+" has joined the LIVE");
            }
        }).buildAndConnect();

    }

    @Override
    public void onDisable() {
        getLogger().info("TikTok Plugin Disabled.");
        
    }
    

}