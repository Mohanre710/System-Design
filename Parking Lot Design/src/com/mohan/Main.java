package com.mohan;

import com.mohan.commands.CommandsFactory;
import com.mohan.mode.FileMode;
import com.mohan.mode.InteractiveMode;
import com.mohan.service.ParkingLotService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //get the execution Mode from args
        final ParkingLotService parkingLotService = new ParkingLotService();
        final CommandsFactory commandsFactory = new CommandsFactory(parkingLotService);
        if(isInteractiveMode(args)){
            //Execute command line logic
            new InteractiveMode(commandsFactory).processMode();
        }else if(isFileMode(args)){
            //Execcute File Mode logic
            new FileMode(args[0], commandsFactory).processMode();
        }else{
            //print or throw invalid mode Exception
        }
    }

    private static boolean isInteractiveMode(String[] args){ return args.length==0;}

    private static boolean isFileMode(String[] args){ return args.length==1;}
}
