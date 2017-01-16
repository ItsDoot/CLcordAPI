package io.github.xdotdash.clcord.api.logging;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LogUtil {

    static final Map<String, Logger> loggers = new ConcurrentHashMap<>();

    static final Map<Class<?>, LogWriter> globalWriters = new ConcurrentHashMap<>();

    public static Map<String, Logger> getLoggers() {
        return Collections.unmodifiableMap(loggers);
    }

    public static Map<Class<?>, LogWriter> getGlobalWriters() {
        return Collections.unmodifiableMap(globalWriters);
    }
}
