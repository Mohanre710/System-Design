package com.mohan.model;

public class Slot {
    private Car parkedCar;
    private int slotNumber;

    Slot(int slotNumber){
        this.slotNumber = slotNumber;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean isSlotFree(){
        return parkedCar==null;
    }

    public void assignCar(Car car){
        this.parkedCar = car;
    }

    public void unAssignCar(){
        this.parkedCar = null;
    }
}
