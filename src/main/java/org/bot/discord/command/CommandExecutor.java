package org.bot.discord.command;

import org.javacord.api.event.message.MessageCreateEvent;

public interface CommandExecutor {

    void run(MessageCreateEvent event, Command command, String[] args);
}
