package org.bot.discord.command;

import org.bot.discord.Main;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Arrays;

/**
 * @author Roberge-Mentec Corentin
 */


public class MessageManager {

    private static final CommandRegistry registry = new CommandRegistry();

    static {
        registry.addCommand(new Command("ping", "Ping the bot", new CommandPing(), "ping", "p"));
        registry.addCommand(new Command("todo", "add a task [optional: enter a date at the format dd/mm/yyyy]", new CommandTodo(), "todo", "t"));
        registry.addCommand(new Command("reminder", "see all the tasks", new CommandReminder(), "reminder", "re"));
        registry.addCommand(new Command("remove", "remove a tasks by its id", new CommandRemove(), "remove", "rm"));
        registry.addCommand(new Command("urgent", "Print the urgent tasks", new CommandUrgent(), "urgent", "u"));
        registry.addCommand(new Command("help", "Print the different commands", new CommandHelp(), "help", "h"));
    }

    private static final String PREFIX = Main.getConfigManager().getToml().getString("bot.prefix");

    /**
     * The static method to create the response of the bot to a given message
     * @param event the message listened by the bot
     */
    public static void create(MessageCreateEvent event){
        if (event.getMessageContent().startsWith(PREFIX)){
            String[] args = event.getMessageContent().split(" ");
            String commandName = args[0].substring(PREFIX.length());
            args = args.length == 1 ? new String[0] : Arrays.copyOfRange(args, 1, args.length);

            String[] finalArgs = args;

            registry.getByAlias(commandName).ifPresent((cmd) -> {
                cmd.getExecutor().run(event, cmd, finalArgs);
            });
        }
    }

    /**
     * Method to get the registry of the different commands
     * @return the registry of the different commands
     */
    public static CommandRegistry getRegistry() {
        return registry;
    }
}
