package com.kep.cnp.sam.management.util;

import org.springframework.format.Formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter  {

    private static String pattern = "yyyyMMdd";
    private static SimpleDateFormat formatter = new SimpleDateFormat(pattern);

    public static String getDateToString(Date date) {
        return formatter.format(date);
    }
}

