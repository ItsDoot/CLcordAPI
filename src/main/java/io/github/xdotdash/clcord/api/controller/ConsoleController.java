package io.github.xdotdash.clcord.api.controller;

import io.github.xdotdash.clcord.command.CommandManager;

public interface ConsoleController extends Controller {

    CommandManager getCommandManager();

    void clearWindow();

}
