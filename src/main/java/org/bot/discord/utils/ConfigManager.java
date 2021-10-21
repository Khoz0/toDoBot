package org.bot.discord.utils;

import com.moandjiezana.toml.Toml;

import java.io.File;

/**
 * @author Roberge-Mentec Corentin
 */


public class ConfigManager {

    private Toml toml;

    public ConfigManager(File file) {
        this.toml = new Toml().read(file);
    }

    public Toml getToml() {
        return toml;
    }

    public void setToml(Toml toml) {
        this.toml = toml;
    }
}
