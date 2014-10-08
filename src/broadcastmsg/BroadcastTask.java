package broadcastmsg;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class BroadcastTask extends BukkitRunnable
{

    private final JavaPlugin plugin;

    private String prefix;
    private List<String> msgs = new ArrayList<String>();

    private int temp = 0;

    private int msgslengh;

    public BroadcastTask(JavaPlugin plugin, FileConfiguration config)
    {
        this.plugin = plugin;
        config = plugin.getConfig();
        prefix = config.getString("messeage-list.prefix");
        msgs = config.getStringList("messeage-list.messeages");
        msgslengh = msgs.size();
    }

    @Override
    public void run()
    {
        if (temp >= msgslengh)
        {
            temp = 0;
        }
        plugin.getServer().broadcastMessage(prefix + msgs.get(temp));
        temp++;

    }
}