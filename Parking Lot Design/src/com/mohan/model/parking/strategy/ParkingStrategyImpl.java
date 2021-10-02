package com.mohan.model.parking.strategy;

import java.util.TreeSet;

public class ParkingStrategyImpl implements ParkingStrategy {

    TreeSet<Integer> treeSet;

    public ParkingStrategyImpl() {
        this.treeSet = new TreeSet<>();
    }

    @Override
    public void addSlot(Integer slotNumber) {
        this.treeSet.add(slotNumber);
    }

    @Override
    public void removeSlot(Integer slotNumber) {
        this.treeSet.remove(slotNumber);
    }

    @Override
    public Integer nextSlot() {
        if(treeSet.isEmpty())
            return -1;
        return this.treeSet.first();
    }
}
