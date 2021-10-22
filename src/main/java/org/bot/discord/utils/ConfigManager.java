package org.bot.discord.utils;

import com.moandjiezana.toml.Toml;

import java.io.File;

/**
 * @author Roberge-Mentec Corentin
 */


public class ConfigManager {

    private Toml toml;

    /**
     * Constructor of the ConfigManager class
     * @param file the file used for the configuration of the bot
     */
    public ConfigManager(File file) {
        this.toml = new Toml().read(file);
    }

    /**
     * Method to get the toml configuration of the bot
     * @return the toml
     */
    public Toml getToml() {
        return toml;
    }

    /**
     * Method to set the toml configuration of the bot
     * @param toml the new toml configuration of the bot
     */
    public void setToml(Toml toml) {
        this.toml = toml;
    }
}
