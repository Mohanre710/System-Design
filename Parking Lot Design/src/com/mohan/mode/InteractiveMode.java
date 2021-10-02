package com.mohan.mode;

import com.mohan.commands.CommandsFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode{

    public InteractiveMode(final CommandsFactory commandsFactory){
        super(commandsFactory);
    }

    @Override
    public void processMode() throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String command = reader.readLine();
            processCommand(command);
            if(command.equals("$exit")){ break;}
        }
    }
}
