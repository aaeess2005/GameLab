package io.github.aaeess2005.gamelab.util;

import java.util.Random;

public class RandomUtil {
    private static Random instance;

    public synchronized static float nextFloat(long seed){
        instance.setSeed(seed);
        return instance.nextFloat();
    }
    public synchronized static double nextDouble(long seed){
        instance.setSeed(seed);
        return instance.nextDouble();
    }
    public synchronized static int nextInt(long seed){
        instance.setSeed(seed);
        return instance.nextInt();
    }
    public synchronized static int nextInt(long seed,int bound){
        instance.setSeed(seed);
        return instance.nextInt(bound);
    }
    public synchronized static boolean nextBoolean(long seed){
        instance.setSeed(seed);
        return instance.nextBoolean();
    }
    public synchronized static long nextLong(long seed){
        instance.setSeed(seed);
        return instance.nextLong();
    }
}
