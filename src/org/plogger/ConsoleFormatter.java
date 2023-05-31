package org.plogger;

import org.plogger.section.LevelSection;
import org.plogger.section.Section;
import org.plogger.section.TimeSection;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class ConsoleFormatter extends Formatter {
    public Map<Level, AnsiColor> levelColors;
    public List<Section> sections;
    public boolean coloredLogs;
    public String dateFormat;

    public ConsoleFormatter() {
        this.coloredLogs = true;
        this.initializeLevelColors();
        this.initializeSections();
    }

    public ConsoleFormatter(Map<Level, AnsiColor> levelColors) {
        this.levelColors = levelColors;
        this.initializeSections();
    }

    public ConsoleFormatter(Map<Level, AnsiColor> levelColors, List<Section> sections) {
        this.levelColors = levelColors;
        this.sections = sections;
    }

    public void initializeLevelColors() {
        this.levelColors = new HashMap<>();
        levelColors.put(Level.SEVERE, AnsiColor.RED);
        levelColors.put(Level.WARNING, AnsiColor.YELLOW);
        levelColors.put(Level.INFO, AnsiColor.BRIGHT_CYAN);
        levelColors.put(Level.CONFIG, AnsiColor.BRIGHT_WHITE);
        levelColors.put(Level.FINE, AnsiColor.BRIGHT_WHITE);
        levelColors.put(Level.FINER, AnsiColor.BRIGHT_WHITE);
        levelColors.put(Level.FINEST, AnsiColor.BRIGHT_WHITE);
    }

    public void initializeSections() {
        this.sections = new ArrayList<>();
        sections.add(new LevelSection(levelColors));
        sections.add(new TimeSection(DateTimeFormatter.ofPattern("u-M-d hh:mm:ss a O")));
//        sections.add(new sections.Section(SectionType.LOGGER_NAME, org.test.AnsiColor.WHITE));
//        sections.add(new sections.Section(SectionType.MESSAGE, org.test.AnsiColor.WHITE));
    }

    @Override
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder();

        for (Section section : sections) {
            builder.append(section.formatSection(record, coloredLogs));
        }

//        builder.append(org.test.AnsiColor.YELLOW.getCode());
//
//        builder.append("[");
//        builder.append(String.valueOf(record.getMillis()));
//        builder.append("]");
//
//        builder.append(" [");
//        builder.append(record.getSourceClassName());
//        builder.append("]");
//
//        builder.append(" [");
//        builder.append(record.getLevel().getName());
//        builder.append("]");
//
//        builder.append(org.test.AnsiColor.WHITE.getCode());
//        builder.append(" - ");
//        builder.append(record.getMessage());

//        Object[] params = record.getParameters();
//
//        if (params != null)
//        {
//            builder.append("\t");
//            for (int i = 0; i < params.length; i++)
//            {
//                builder.append(params[i]);
//                if (i < params.length - 1)
//                    builder.append(", ");
//            }
//        }
//
//        builder.append(AnsiColor.RESET.getCode());
        builder.append("\n");
        return builder.toString();
    }
}
