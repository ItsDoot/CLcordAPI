package io.github.xdotdash.clcord.api.plugin.loading;

import java.io.File;
import java.util.Optional;

/**
 * Used to load a plugin instance from a file.
 */
@FunctionalInterface
public interface PluginLoader {

    /**
     * Searches the specified file for a plugin, and loads it if present.
     *
     * @param file The file to search.
     * @return A
     */
    Optional<Object> load(File file);

}