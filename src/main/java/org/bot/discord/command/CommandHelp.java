package org.bot.discord.command;

import org.javacord.api.event.message.MessageCreateEvent;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Roberge-Mentec Corentin
 */


public class CommandHelp implements CommandExecutor {
    /**
     * @param event   the message listened by the bot
     * @param command the command adapted to the message
     * @param args    the information to complete the command
     */
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        ArrayList<Command> commands = MessageManager.getRegistry().getCommands();
        StringBuilder stringBuilder = new StringBuilder();

        for (Command c: commands){
            stringBuilder.append(c.getId());
            stringBuilder.append(" ");
            stringBuilder.append(c.getDescription());
            stringBuilder.append(" ");
            stringBuilder.append(Arrays.toString(c.getAliases()));
            stringBuilder.append("\n");
        }
    }
}
