package org.bot.discord.command;

import org.javacord.api.event.message.MessageCreateEvent;

/**
 * @author Roberge-Mentec Corentin
 */


public class CommandPing implements CommandExecutor {
    /**
     * @param event   the message listened by the bot
     * @param command the command adapted to the message
     * @param args    the information to complete the command
     */
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        System.out.println("Response");
        event.getChannel().sendMessage("Pong !");

    }
}
