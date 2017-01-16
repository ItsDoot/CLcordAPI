package io.github.xdotdash.clcord.api.logging;

import javax.annotation.Nullable;

import static io.github.xdotdash.clcord.api.logging.LogUtil.globalWriters;

public interface LogWriter {

    static void addGlobalWriter(LogWriter writer) {
        globalWriters.put(writer.getClass(), writer);
    }

    void write(Priority priority, String name, String message, @Nullable Throwable throwable);
}
