package io.github.xdotdash.clcord.api.controller;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;

public interface DiscordController extends Controller {

    JDA getJDA();

    Guild getCurrentGuild();

    void setCurrentGuild(Guild guild);

    TextChannel getCurrentChannel();

    void setCurrentChannel(TextChannel channel);

}