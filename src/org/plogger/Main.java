package org.plogger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        logger.setUseParentHandlers(false);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new ConsoleFormatter());
        logger.addHandler(consoleHandler);

        logger.info("Log");
        logger.log(Level.SEVERE, "severe");
        logger.log(Level.WARNING, "warning");
        logger.log(Level.INFO, "info");
    }
}