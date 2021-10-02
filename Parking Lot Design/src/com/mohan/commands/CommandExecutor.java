package com.mohan.commands;

import com.mohan.model.Command;
import com.mohan.service.ParkingLotService;

public abstract class CommandExecutor {
    protected ParkingLotService parkingLotService;

    CommandExecutor(ParkingLotService parkingLotService){
        this.parkingLotService = parkingLotService;
    }

    public abstract boolean validateCommand(Command command);

    public abstract void execute(Command command);
}
