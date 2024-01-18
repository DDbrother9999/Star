package net.Star.Utils;

import net.Star.Star;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class Tasks {

    public static void runAsync(Runnable runnable) {
        org.bukkit.Bukkit.getScheduler().runTaskAsynchronously(Star.getInstance(), runnable);
    }

    public static void runSync(Runnable runnable) {
        org.bukkit.Bukkit.getScheduler().runTask(Star.getInstance(), runnable);
    }

    public static void runSyncLater(Runnable runnable, long delay) {
        org.bukkit.Bukkit.getScheduler().runTaskLater(Star.getInstance(), runnable, delay);
    }

    public static void runSyncTimer(Runnable runnable, long delay, long period) {
        org.bukkit.Bukkit.getScheduler().runTaskTimer(Star.getInstance(), runnable, delay, period);
    }

    public static void runSyncTimerAsync(Runnable runnable, long delay, long period) {
        org.bukkit.Bukkit.getScheduler().runTaskTimerAsynchronously(Star.getInstance(), runnable, delay, period);
    }

    public static BukkitTask runTaskLater(Runnable run, long delay, TimeUnit unit) {
        return Bukkit.getScheduler().runTaskLater(Star.getInstance(), run, unit.toSeconds(delay) * 20L);
    }

    public static BukkitTask runTaskTimerAsync(Runnable run, long start, long repeat) {
        return Bukkit.getScheduler().runTaskTimerAsynchronously(Star.getInstance(), run, start, repeat);
    }

    public static int scheduleSyncRepeatingTask(Runnable run, long start, long repeat) {
        return Bukkit.getScheduler().scheduleSyncRepeatingTask(Star.getInstance(), run, start, repeat);
    }
}