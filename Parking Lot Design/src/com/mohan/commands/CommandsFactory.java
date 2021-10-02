package com.mohan.commands;

import com.mohan.model.Command;
import com.mohan.service.ParkingLotService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandsFactory {

    private static Map<String, CommandExecutor> commandExecutorMap = new HashMap<>();


    public CommandsFactory(final ParkingLotService parkingLotService){
        commandExecutorMap.put(CreateParkingLotCommandExecutor.COMMAND_NAME,new CreateParkingLotCommandExecutor(parkingLotService));
        commandExecutorMap.put(LeaveCommandExecutor.COMMAND_NAME,new LeaveCommandExecutor(parkingLotService));
        commandExecutorMap.put(ParkCommandExecutor.COMMAND_NAME,new ParkCommandExecutor(parkingLotService));
        commandExecutorMap.put(StatusCommandExecutor.COMMAND_NAME,new StatusCommandExecutor(parkingLotService));
        commandExecutorMap.put(SlotForRegistrationNumber.COMMAND_NAME,new SlotForRegistrationNumber(parkingLotService));
        commandExecutorMap.put(ExitCommandExecutor.COMMAND_NAME,new ExitCommandExecutor(parkingLotService));
    }

    public CommandExecutor getCommandExecutor(final Command command){
        final CommandExecutor commandExecutor = commandExecutorMap.get(command.getCommandName());
        if(commandExecutor==null) {
            System.out.println("Invalid command passed");
            return null;
        }
        return commandExecutor;
    }

}
