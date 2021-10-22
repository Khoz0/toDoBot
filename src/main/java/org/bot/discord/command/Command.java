package org.bot.discord.command;

/**
 * @author Roberge-Mentec Corentin
 */


public class Command {

    private String id, description;
    private String[] aliases;
    private CommandExecutor executor;

    /**
     * The constructor of the Command class
     * @param id the id of a command
     * @param description the description of a command
     * @param executor the CommandExecutor used for a command
     * @param aliases the different aliases of a command
     */
    public Command(String id, String description, CommandExecutor executor, String... aliases) {
        this.id = id;
        this.description = description;
        this.aliases = aliases;
        this.executor = executor;
    }

    /**
     * The method to get the id of a command
     * @return the id of a command
     */
    public String getId() {
        return id;
    }

    /**
     * The method to get the description of a command
     * @return the description of a command
     */
    public String getDescription() {
        return description;
    }

    /**
     * The method to get the different aliases of a command
     * @return the aliases of a command
     */
    public String[] getAliases() {
        return aliases;
    }

    /**
     * The method to get the command executor of a command
     * @return the command executor of a command
     */
    public CommandExecutor getExecutor() {
        return executor;
    }
}
