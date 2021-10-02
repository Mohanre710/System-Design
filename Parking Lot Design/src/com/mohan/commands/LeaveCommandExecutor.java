package com.mohan.commands;

import com.mohan.model.Command;
import com.mohan.service.ParkingLotService;

public class LeaveCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "leave";
    LeaveCommandExecutor(final ParkingLotService parkingLotService){
        super(parkingLotService);
    }

    @Override
    public boolean validateCommand(Command command) {
        return command.getCommandParams().size()==1;
    }

    @Override
    public void execute(Command command) {
        Integer slotFree = parkingLotService.unPark(Integer.parseInt(command.getCommandParams().get(0)));
        System.out.println("Slot number "+slotFree+" is Free");
    }
}
