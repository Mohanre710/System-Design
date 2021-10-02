package com.mohan.commands;

import com.mohan.model.Command;
import com.mohan.model.Slot;
import com.mohan.service.ParkingLotService;

import java.util.List;
import java.util.Optional;

public class SlotForRegistrationNumber extends CommandExecutor{
    public static String COMMAND_NAME = "slot_number_for_registration_number";
    SlotForRegistrationNumber(final ParkingLotService parkingLotService){
        super(parkingLotService);
    }

    @Override
    public boolean validateCommand(Command command) {
        return command.getCommandParams().size()==1;
    }

    @Override
    public void execute(Command command) {
        final List<Slot> occupiedSlots = parkingLotService.getOccupiedSlot();
        final String registrationNumber = command.getCommandParams().get(0);
        final Optional<Slot> slotFound = occupiedSlots
                .stream()
                .filter(slot->slot.getParkedCar().getRegistrationNumber().equals(registrationNumber)).findFirst();

        if(slotFound.isPresent())
            System.out.println("Slot is found at " + slotFound.get().getSlotNumber());
        else
            System.out.println("Slot Not Found");
    }
}
