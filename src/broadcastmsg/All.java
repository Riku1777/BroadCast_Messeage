package broadcastmsg;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class All extends JavaPlugin implements Listener
{
    public int taskid;
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();

    }
    public void onDisable()
    {

    }

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event)
    {
        int interval = this.getConfig().getInt("messeage-list.interval");
        new BroadcastTask(this, this.getConfig()).runTaskTimer(this, 10, 20 * interval);
    }
}
