package org.bot.discord.command;

import org.javacord.api.event.message.MessageCreateEvent;

public interface CommandExecutor {

    /**
     * The run method that process the given command to answer
     * @param event the message listened by the bot
     * @param command the command adapted to the message
     * @param args the information to complete the command
     */
    void run(MessageCreateEvent event, Command command, String[] args);
}
