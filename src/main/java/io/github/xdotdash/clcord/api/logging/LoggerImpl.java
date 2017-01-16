package io.github.xdotdash.clcord.api.logging;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static io.github.xdotdash.clcord.api.logging.LogUtil.globalWriters;
import static io.github.xdotdash.clcord.api.logging.LogUtil.loggers;

class LoggerImpl implements Logger {

    private final String name;
    private Priority priority = null;

    private final boolean onlyLocalWriters;
    private List<LogWriter> localWriters = new CopyOnWriteArrayList<>();

    public LoggerImpl(String name) {
        this(name, false);
    }

    public LoggerImpl(String name, boolean onlyLocalWriters) {
        this.name = name;
        this.onlyLocalWriters = onlyLocalWriters;
    }

    @Override
    public Logger addLocalWriter(LogWriter logWriter) {
        localWriters.add(logWriter);
        loggers.put(name, this);
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Priority getPriority() {
        return priority != null ? priority : Priority.DEFAULT;
    }

    @Override
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public void log(Priority priority, String message, @Nullable Throwable throwable) {
        if (onlyLocalWriters && localWriters.isEmpty() || localWriters.isEmpty() && globalWriters.isEmpty()) {
            throw new IllegalStateException("No LogWriters found.");
        }

        if (isEnabled(priority)) {
            for (LogWriter writer : localWriters) {
                writer.write(priority, this.name, message, throwable);
            }
            if (!onlyLocalWriters) {
                for (LogWriter writer : globalWriters.values()) {
                    writer.write(priority, this.name, message, throwable);
                }
            }
        }
    }
}
