package org.bot.discord;

import org.bot.discord.command.MessageManager;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.bot.discord.utils.ConfigManager;
import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * @author Roberge-Mentec Corentin
 */


public class Main {

    private static DiscordApi api;
    private static ConfigManager configManager;

    /**
     * Main of the program
     * @param args arguments send to the main at the execution of the program
     */
    public static void main(String[] args) {

        configManager = new ConfigManager(new File(System.getProperty("user.dir"), "config.toml"));

        api = new DiscordApiBuilder().setToken(configManager.getToml().getString("bot.token")).login().join();

        api.addMessageCreateListener(MessageManager::create);
        System.out.println("listening to messages");

        // Message to see the connection of the bot
        TextChannel channel = null;
        Optional<TextChannel> textChannel = api.getTextChannelById("726095642924941343");
        if (textChannel.isPresent()){
            channel = textChannel.get();
        }
        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.setContent("@everyone Hello i'm awake !");
        messageBuilder.send(channel);

    }

    /**
     * Method to get the config manager of the bot
     * @return the config manager of the bot
     */
    public static ConfigManager getConfigManager() {
        return configManager;
    }
}
