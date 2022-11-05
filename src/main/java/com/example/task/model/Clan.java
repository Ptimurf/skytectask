package com.example.task.model;

import lombok.Builder;

@Builder
public class Clan {
    private long id;
    private String name;
    private int gold;

    public synchronized int getGold() {
        return gold;
    }

    public synchronized void setGold(int gold) {
        this.gold = gold;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

}
