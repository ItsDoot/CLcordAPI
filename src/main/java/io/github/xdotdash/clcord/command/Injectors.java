package io.github.xdotdash.clcord.command;

import com.sk89q.intake.Intake;
import com.sk89q.intake.parametric.Injector;
import com.sk89q.intake.parametric.Module;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Injectors {
    private Injectors() {
    }

    private static final List<Module> injectorModules = new CopyOnWriteArrayList<>();

    public static void addModule(Module module) {
        injectorModules.add(module);
    }

    public static Injector create() {
        Injector injector = Intake.createInjector();
        injectorModules.forEach(injector::install);
        return injector;
    }

}
