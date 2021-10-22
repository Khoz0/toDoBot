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

        stringBuilder.append("List of commands:\n```");

        for (Command c: commands){
            stringBuilder.append("!");
            stringBuilder.append(c.getId());
            stringBuilder.append(": ");
            stringBuilder.append(c.getDescription());
            stringBuilder.append(". Aliases: ");
            int cpt = 0;
            for (String s: c.getAliases()) {
                stringBuilder.append(s);
                if (cpt < c.getAliases().length-1){
                    stringBuilder.append(", ");
                }
                cpt++;
            }
            stringBuilder.append(".\n");
        }

        stringBuilder.append("```");
        event.getChannel().sendMessage(String.valueOf(stringBuilder));
    }
}
