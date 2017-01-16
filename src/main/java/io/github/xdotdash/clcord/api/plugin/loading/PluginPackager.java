package io.github.xdotdash.clcord.api.plugin.loading;

import io.github.xdotdash.clcord.api.plugin.PluginContainer;

import java.util.Optional;

/**
 * Used for packaging plugin instances into {@link PluginContainer}s.
 */
@FunctionalInterface
public interface PluginPackager {

    /**
     * Packs the specified plugin instance into a {@link PluginContainer}, if possible.
     *
     * @param instance The plugin instance
     * @return The packaged container, if available
     */
    Optional<PluginContainer> pack(Object instance);

}