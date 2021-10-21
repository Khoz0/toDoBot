package org.bot.discord.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author Roberge-Mentec Corentin
 */


public class CommandRegistry {

    private ArrayList<Command> commands;

    public CommandRegistry(){
        this.commands = new ArrayList<>();
    }

    public void addCommand(Command cmd){
        commands.add(cmd);
    }

    public void removeCommand(String id){
        commands.removeIf((cmd) -> cmd.getId().equalsIgnoreCase(id));
    }

    public Optional<Command> getByAlias(String alias){
        for (Command command : commands) {
            if (Arrays.asList(command.getAliasses()).contains(alias)){
                return Optional.of(command);
            }
        }
        return Optional.empty();
    }
}
