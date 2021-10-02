package com.mohan.commands;

import com.mohan.model.Command;
import com.mohan.model.ParkingLot;
import com.mohan.model.parking.strategy.ParkingStrategyImpl;
import com.mohan.service.ParkingLotService;

import java.util.List;

public class CreateParkingLotCommandExecutor extends CommandExecutor{
    public static final String COMMAND_NAME = "create_parking_lot";

    CreateParkingLotCommandExecutor(final ParkingLotService parkingLotService){
        super(parkingLotService);
    }

    @Override
    public boolean validateCommand(Command command) {
        return command.getCommandParams().size()==1;
    }

    @Override
    public void execute(Command command) {
        final int parkingLotCapacity = Integer.parseInt(command.getCommandParams().get(0));
        final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(parkingLot,new ParkingStrategyImpl());
    }
}
