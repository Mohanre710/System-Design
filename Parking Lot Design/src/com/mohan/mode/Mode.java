package com.mohan.mode;

import com.mohan.commands.CommandExecutor;
import com.mohan.commands.CommandsFactory;
import com.mohan.model.Command;

import java.io.IOException;

public abstract class Mode {

    private CommandsFactory commandsFactory;
    Mode(final CommandsFactory commandsFactory){
        this.commandsFactory = commandsFactory;
    }

    protected void processCommand(final String inputCommand){
        //process the command
        final Command command = new Command(inputCommand);
        final CommandExecutor commandExecutor= commandsFactory.getCommandExecutor(command);
        commandExecutor.execute(command);
    }

    public abstract void processMode() throws IOException;
}
