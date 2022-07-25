package io.github.aaeess2005.gamelab.util;

public class DeltaUtil {
    private static float delta;
    private static long lastTime = TimeUtil.getMilli();

    public static void resetDelta() {
        delta = ((float) (TimeUtil.getMilli() - lastTime)) / 1000f;
        lastTime = TimeUtil.getMilli();
    }

    public static float getDelta() {
        return delta;
    }
}
