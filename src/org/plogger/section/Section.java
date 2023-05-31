package org.plogger.section;

import java.util.logging.LogRecord;

public abstract class Section {
    public String formatSection(LogRecord message, boolean coloredLogs) {
//        if (!coloredLogs) return "[" + message + "]";
        return "[" + message + "]";
    }
}
