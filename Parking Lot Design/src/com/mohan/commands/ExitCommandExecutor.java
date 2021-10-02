package com.mohan.commands;

import com.mohan.model.Command;
import com.mohan.service.ParkingLotService;

public class ExitCommandExecutor extends CommandExecutor{
    public static final String COMMAND_NAME = "$exit";
    ExitCommandExecutor(final ParkingLotService parkingLotService){
        super(parkingLotService);
    }

    @Override
    public boolean validateCommand(Command command) {
        return command.getCommandParams().size()==0;
    }

    @Override
    public void execute(Command command) {
        System.out.println("Exited Successfully");
    }
}
