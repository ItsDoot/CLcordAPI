package io.github.xdotdash.clcord.api.logging;

import javax.annotation.Nullable;

import static io.github.xdotdash.clcord.api.logging.LogUtil.loggers;

public interface Logger {

    static Logger of(String name) {
        return of(name, false);
    }

    static Logger of(String name, boolean onlyLocalWriters) {
        if (loggers.containsKey(name)) {
            return loggers.get(name);
        } else {
            Logger logger = new LoggerImpl(name, onlyLocalWriters);
            loggers.put(name, logger);
            return logger;
        }
    }

    Logger addLocalWriter(LogWriter logWriter);

    String getName();

    Priority getPriority();

    void setPriority(Priority priority);

    default boolean isEnabled(Priority priority) {
        return getPriority().value <= priority.value;
    }

    default void log(Priority priority, String message) {
        log(priority, message, null);
    }

    void log(Priority priority, String message, @Nullable Throwable throwable);

    default void fatal(String message) {
        log(Priority.FATAL, message);
    }

    default void fatal(String message, Throwable throwable) {
        log(Priority.FATAL, message, throwable);
    }

    default void severe(String message) {
        log(Priority.SEVERE, message);
    }

    default void severe(String message, Throwable throwable) {
        log(Priority.SEVERE, message, throwable);
    }

    default void warning(String message) {
        log(Priority.WARNING, message);
    }

    default void warning(String message, Throwable throwable) {
        log(Priority.WARNING, message, throwable);
    }

    default void info(String message) {
        log(Priority.INFO, message);
    }

    default void info(String message, Throwable throwable) {
        log(Priority.INFO, message, throwable);
    }

    default void debug(String message) {
        log(Priority.DEBUG, message);
    }

    default void debug(String message, Throwable throwable) {
        log(Priority.DEBUG, message, throwable);
    }

    default void trace(String message) {
        log(Priority.TRACE, message);
    }

    default void trace(String message, Throwable throwable) {
        log(Priority.TRACE, message, throwable);
    }
}
