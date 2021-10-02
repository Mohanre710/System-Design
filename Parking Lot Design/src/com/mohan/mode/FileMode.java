package com.mohan.mode;

import com.mohan.commands.CommandsFactory;
import com.mohan.service.ParkingLotService;

import java.io.*;

public class FileMode extends Mode{
    private String filename;
    public FileMode(String filename, final CommandsFactory commandsFactory){
        super(commandsFactory);
        this.filename = filename;
    }

    @Override
    public void processMode() throws IOException {
        File file = new File(filename);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        }catch (FileNotFoundException f){
            System.out.println("Invalid File Name passed: "+ filename);
            return;
        }

        String input = reader.readLine();
        while(input!=null){
            processCommand(input);
            input = reader.readLine();
        }

    }


}
