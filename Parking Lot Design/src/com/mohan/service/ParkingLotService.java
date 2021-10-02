package com.mohan.service;

import com.mohan.model.Car;
import com.mohan.model.ParkingLot;
import com.mohan.model.Slot;
import com.mohan.model.parking.strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLotService {
    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public ParkingLotService(){

    }

    public void createParkingLot(final ParkingLot parkingLot, final ParkingStrategy parkingStrategy) {
        if(parkingLot!=null){
            //throw new parkingLot already exist
        }
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;

        for(int i=1;i<=parkingLot.getCapacity();i++) {
            parkingStrategy.addSlot(i);
        }
    }

    public Integer park(final Car car){
        validParkingLotExist();
        final Integer nextFreeSlot = parkingStrategy.nextSlot();
        parkingLot.parkCar(car,nextFreeSlot);
        parkingStrategy.removeSlot(nextFreeSlot);
        return nextFreeSlot;
    }

    public Integer unPark(final Integer slotNumber){
        validParkingLotExist();
        parkingLot.unParkCar(slotNumber);
        parkingStrategy.addSlot(slotNumber);
        return slotNumber;
    }

    public List<Slot> getOccupiedSlot(){
        validParkingLotExist();
        final List<Slot> occupiedSlots = new ArrayList<>();
        final Map<Integer,Slot> allSlots = parkingLot.getSlots();
        for(Integer key : allSlots.keySet()){
            final Slot slot = allSlots.get(key);
            if(!slot.isSlotFree())
                occupiedSlots.add(slot);
        }
        return occupiedSlots;
    }

    public void validParkingLotExist(){
        if(parkingLot==null){
            //throw parkignLot Exception
        }
    }

    public List<Slot> getSlotsForColor(final String color){
        final List<Slot> occupiedSlots = getOccupiedSlot();

        return occupiedSlots.stream()
                .filter(slot -> slot.getParkedCar().getColor().equals(color))
                .collect(Collectors.toList());

    }
}
