package io.github.xdotdash.clcord.api.plugin;

import java.util.Optional;

public interface PluginContainer {

    String getId();

    default String getName() {
        return getId();
    }

    default Optional<String> getVersion() {
        return Optional.empty();
    }

    default Optional<?> getInstance() {
        return Optional.empty();
    }

    default boolean isEnabled() {
        return false;
    }

    void enable();

    void disable();

}