package com.eurowings.utils;

import com.eurowings.exceptions.ParseDateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.eurowings.utils.Date.TODAY;
import static com.eurowings.utils.Date.TOMORROW;

public class DateUtils {
    public static String formatLocalDate(LocalDate date, String dateFormat, Locale locale) {
        return DateTimeFormatter.ofPattern(dateFormat, locale).format(date);
    }

    private static LocalDate getTodayDate() {
        return LocalDate.now();
    }

    private static LocalDate getTomorrowDate() {
        return LocalDate.now().plusDays(1);
    }

    public static String parseDate(String date, String dateFormat) {
        if (date.equals(TOMORROW.date)) {
            return formatLocalDate(getTomorrowDate(), dateFormat, Locale.getDefault());
        } else if (date.equals(TODAY.date)) {
            return formatLocalDate(getTodayDate(), dateFormat, Locale.getDefault());
        }
        return validateDate(date, dateFormat);
    }

    private static String validateDate(String date, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(date);
        } catch (ParseException parseException) {
            throw new ParseDateException(String.format("The date %s isn't valid", date));
        }
        return date;
    }
}
