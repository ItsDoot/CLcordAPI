package io.github.xdotdash.clcord.api;

import io.github.xdotdash.clcord.api.controller.ConsoleController;
import io.github.xdotdash.clcord.api.controller.DiscordController;

public interface CLcord {

    ConsoleController getConsole();

    DiscordController getDiscord();

}