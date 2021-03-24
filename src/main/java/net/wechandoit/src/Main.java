package net.wechandoit.src;

import com.bgsoftware.wildstacker.api.WildStackerAPI;
import com.bgsoftware.wildstacker.api.objects.StackedSpawner;
import com.songoda.ultimatestacker.UltimateStacker;
import com.songoda.ultimatestacker.stackable.spawner.SpawnerStack;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        // convert
        convert();
    }

    public void convert() {
        Collection<SpawnerStack> usStacks = UltimateStacker.getInstance().getSpawnerStackManager().getStacks();
        int count = 0;
        for (SpawnerStack spawnerStack : usStacks) {
            Block block = spawnerStack.getLocation().getBlock();
            if (block.getType().equals(Material.MOB_SPAWNER)) {
                StackedSpawner spawner = WildStackerAPI.getStackedSpawner((CreatureSpawner) spawnerStack.getLocation().getBlock().getState());
                spawner.setStackAmount(spawnerStack.getAmount(), true);
                count++;
            }
        }
        System.out.println("USCONVERTER: " + count + " spawners converted!");
    }
}
