package org.bot.discord.command;

/**
 * @author Roberge-Mentec Corentin
 */


public class Command {

    private String id, description;
    private String[] aliasses;
    private CommandExecutor executor;

    public Command(String id, String description, CommandExecutor executor, String... aliasses) {
        this.id = id;
        this.description = description;
        this.aliasses = aliasses;
        this.executor = executor;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String[] getAliasses() {
        return aliasses;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }
}
