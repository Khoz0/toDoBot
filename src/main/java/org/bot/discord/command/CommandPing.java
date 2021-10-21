package org.bot.discord.command;

import org.javacord.api.event.message.MessageCreateEvent;

/**
 * @author Roberge-Mentec Corentin
 */


public class CommandPing implements CommandExecutor {
    @Override
    public void run(MessageCreateEvent event, Command command, String[] args) {
        System.out.println("Response");
        event.getChannel().sendMessage("Pong !");

    }
}
