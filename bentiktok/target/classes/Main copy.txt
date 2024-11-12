package mc.tiktok;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
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

    @Override
    public void onEnable() {

        getLogger().info("TikTok Plugin Enabled.");


        TikTokLive.newClient("bumsdito").onComment((liveClient, e) -> {
            

            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(Main.GREEN+e.getUser().getName()+": "+Main.GRAY+e.getText());
                switch (e.getText()) {
                    case "drop":
                    break;
                    case "blind":
                        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5, 255));
                    break;
                }


            }
            
            

        }).onGift((liveClient, tikTokGiftEvent) -> {
            
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