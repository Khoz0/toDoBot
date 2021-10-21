package org.bot.discord;

import org.bot.discord.command.MessageManager;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.bot.discord.utils.ConfigManager;

import java.io.File;

/**
 * @author Roberge-Mentec Corentin
 */


public class Main {

    private static DiscordApi api;
    private static ConfigManager configManager;


    public static void main(String[] args) {

        configManager = new ConfigManager(new File(System.getProperty("user.dir"), "config.toml"));

        api = new DiscordApiBuilder().setToken(configManager.getToml().getString("bot.token")).login().join();

        api.addMessageCreateListener(MessageManager::create);
        System.out.println("listening to messages");

    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }
}
