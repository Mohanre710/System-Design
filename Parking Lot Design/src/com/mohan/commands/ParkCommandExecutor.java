package com.mohan.commands;

import com.mohan.model.Car;
import com.mohan.model.Command;
import com.mohan.service.ParkingLotService;

public class ParkCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "park";

    ParkCommandExecutor(final ParkingLotService parkingLotService){
        super(parkingLotService);
    }

    @Override
    public boolean validateCommand(Command command) {
        return command.getCommandParams().size()==2;
    }

    @Override
    public void execute(Command command) {
        final Car car  = new Car(command.getCommandParams().get(0),command.getCommandParams().get(1));
        try{
            final Integer slot = parkingLotService.park(car);
            System.out.println("Alloted slot Number: "+ slot);
        }catch(Exception e){
            System.out.println("No parking slot available");
        }
    }
}
