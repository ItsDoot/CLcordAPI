package io.github.xdotdash.clcord.api.plugin;

public @interface Plugin {

    String id();

    String name() default "";

    String version() default "";

}