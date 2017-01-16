package io.github.xdotdash.clcord.api.logging;

public enum Priority {

    OFF(Integer.MAX_VALUE),

    FATAL(6),

    SEVERE(5),

    WARNING(4),

    INFO(3),

    DEBUG(2),

    TRACE(1),

    ON(Integer.MIN_VALUE);

    public final int value;

    Priority(int value) {
        this.value = value;
    }

    public static Priority DEFAULT = INFO;
}
