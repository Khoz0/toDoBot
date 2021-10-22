package org.bot.discord.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author Roberge-Mentec Corentin
 */


public class CommandRegistry {

    private ArrayList<Command> commands;

    /**
     * The constructor of the CommandRegistry class
     */
    public CommandRegistry(){
        this.commands = new ArrayList<>();
    }

    /**
     * The method to add a command to the command registry
     * @param cmd the command to add to the registry
     */
    public void addCommand(Command cmd){
        commands.add(cmd);
    }

    /**
     * The method to remove a command from the command registry by id
     * @param id the id of the command to remove from the command registry
     */
    public void removeCommand(String id){
        commands.removeIf((cmd) -> cmd.getId().equalsIgnoreCase(id));
    }

    public Optional<Command> getByAlias(String alias){
        for (Command command : commands) {
            if (Arrays.asList(command.getAliases()).contains(alias)){
                return Optional.of(command);
            }
        }
        return Optional.empty();
    }

    /**
     * The method to obtain the list of the commands from the command registry
     * @return the list of commands contained in the command registry
     */
    public ArrayList<Command> getCommands() {
        return commands;
    }
}
