package com.mohan.model;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final int MAX_CAPACITY = 10000;
    private int capacity;
    private Map<Integer, Slot> slots;

    public ParkingLot(final int capacity){
        if(capacity<=0 && capacity>MAX_CAPACITY){
            System.out.println("Invalid parking lot capacity");
            return;
        }
        this.capacity = capacity;
        this.slots = new HashMap<>();
    }
    public Integer getCapacity() {
        return this.capacity;
    }
    public Map<Integer, Slot> getSlots(){
        return this.slots;
    }

    private Slot getSlot(final Integer slotNumber){
        if(slotNumber>MAX_CAPACITY || slotNumber<=0) {
            System.out.println("Invalid Slot Number");
            return null;
        }
        if(!this.slots.containsKey(slotNumber))
            this.slots.put(slotNumber,new Slot(slotNumber));
        return this.slots.get(slotNumber);
    }

    public Slot parkCar(final Car car, final Integer slotNumber){
        final Slot slot = getSlot(slotNumber);
        if(slot==null || !slot.isSlotFree()){
            System.out.println("Invalid slot or Slot is Already occupied");
            return null;
        }
        slot.assignCar(car);
        return slot;
    }

    public Slot unParkCar(final Integer slotNumber){
        final Slot slot = getSlot(slotNumber);
        if(slot==null){
            System.out.println("Invalid slot. please check!");
            return null;
        }
        slot.unAssignCar();
        return slot;
    }
}
