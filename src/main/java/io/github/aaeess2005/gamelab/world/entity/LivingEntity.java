package io.github.aaeess2005.gamelab.world.entity;

import org.joml.Vector3f;
import java.util.UUID;

public class LivingEntity extends Entity{
    private float health;

    public float getHealth() {
        return health;
    }
    public void setHealth(float health) {
        this.health = health;
    }
}
