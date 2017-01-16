package io.github.xdotdash.clcord.api.plugin;

import java.io.File;
import java.util.Collection;
import java.util.Optional;

public interface PluginManager {

    Collection<PluginContainer> getPlugins();

    Optional<PluginContainer> getPlugin(String id);

    boolean isLoaded(String id);

    void loadPlugins(File directory);

}