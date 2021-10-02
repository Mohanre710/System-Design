package com.mohan.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {
    private final static String SPACE = " ";
    private String commandName;
    private List<String> commandParams;

    public String getCommandName() {
        return commandName;
    }

    public List<String> getCommandParams() {
        return commandParams;
    }

    public Command(String input){
        final List<String> tempInput= Arrays.stream(input.trim().split(SPACE))
                .map(String::trim)
                .filter(temp->(temp.length()>0))
                .collect(Collectors.toList());

        if(tempInput.size()==0){
            System.out.println("Invalid Command Passed");
            return;
        }

        this.commandName = tempInput.get(0).toLowerCase();
        tempInput.remove(0);
        this.commandParams = tempInput;
    }
}
