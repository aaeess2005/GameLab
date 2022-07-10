package io.github.aaeess2005.gamelab.world.entity;

import org.joml.Vector3f;

import java.util.UUID;

/**
 * 所有实体的父类
 * 实体表示游戏中的活动对象，比如：玩家、生物、按钮、物品
 */
public abstract class Entity {
    private UUID uuid;
    private Vector3f position,rotation;

    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public Vector3f getPosition() {
        return position;
    }
    public void setPosition(Vector3f position) {
        this.position = position;
    }
    public Vector3f getRotation() {
        return rotation;
    }
    public void setRotation(Vector3f rotation) {
        this.rotation = rotation;
    }
}
