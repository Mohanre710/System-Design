package com.mohan.commands;

import com.mohan.model.Command;
import com.mohan.model.Slot;
import com.mohan.service.ParkingLotService;

import java.util.List;

public class StatusCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "status";
    StatusCommandExecutor(final ParkingLotService parkingLotService){
        super(parkingLotService);
    }

    @Override
    public boolean validateCommand(Command command) {
        return command.getCommandParams().size()==0;
    }

    @Override
    public void execute(Command command) {
        final List<Slot> occupiedSlot = parkingLotService.getOccupiedSlot();
        System.out.println(" SlotNo. RegistrationNo. Color");
        for(Slot slot: occupiedSlot){
            System.out.println(slot.getSlotNumber()+"      "+slot.getParkedCar().getRegistrationNumber()+" "+slot.getParkedCar().getColor());
        }
    }
}
