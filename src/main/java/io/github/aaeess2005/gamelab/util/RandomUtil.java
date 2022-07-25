package io.github.aaeess2005.gamelab.util;

import java.util.Random;

public class RandomUtil {
    private static Random instance;

    public static float nextFloat(long seed) {
        instance.setSeed(seed);
        return instance.nextFloat();
    }

    public static double nextDouble(long seed) {
        instance.setSeed(seed);
        return instance.nextDouble();
    }

    public static int nextInt(long seed) {
        instance.setSeed(seed);
        return instance.nextInt();
    }

    public static int nextInt(long seed, int bound) {
        instance.setSeed(seed);
        return instance.nextInt(bound);
    }

    public static boolean nextBoolean(long seed) {
        instance.setSeed(seed);
        return instance.nextBoolean();
    }

    public static long nextLong(long seed) {
        instance.setSeed(seed);
        return instance.nextLong();
    }
}
