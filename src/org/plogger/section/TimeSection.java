package org.plogger.section;

import org.plogger.AnsiColor;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class TimeSection extends Section {
    private DateTimeFormatter dateTimeFormatter;

    public TimeSection() {

    }

    public TimeSection(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    @Override
    public String formatSection(LogRecord record, boolean coloredLogs) {
        if (!coloredLogs) return "[" + formatDate(record.getMillis()) + "]";
        return AnsiColor.BRIGHT_WHITE.getCode() + "[" + formatDate(record.getMillis()) + "]" + AnsiColor.RESET.getCode();
    }

    public String formatDate(long millis) {
        if (dateTimeFormatter == null) return String.valueOf(millis);
        return ZonedDateTime.now().format(dateTimeFormatter);
    }
}
