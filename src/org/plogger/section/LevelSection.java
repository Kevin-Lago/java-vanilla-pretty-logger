package org.plogger.section;

import org.plogger.AnsiColor;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class LevelSection extends Section {
    public Map<Level, AnsiColor> levelColors;

    public LevelSection(Map<Level, AnsiColor> levelColors) {
        this.levelColors = levelColors;
    }

    @Override
    public String formatSection(LogRecord record, boolean coloredLogs) {
        if (!coloredLogs) return "[" + record.getLevel() + "]";
        String color = levelColors.get(record.getLevel()).getCode();
        return AnsiColor.BRIGHT_WHITE.getCode() + "[" + color + String.format("%0$-" + 8 + "s", record.getLevel()) + AnsiColor.BRIGHT_WHITE.getCode() + "]" + AnsiColor.RESET.getCode();
    }
}
