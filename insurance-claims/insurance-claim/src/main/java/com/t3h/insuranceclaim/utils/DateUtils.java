package com.t3h.insuranceclaim.utils;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final String YYYYMMDD = "yyyy-MM-dd";

    public static LocalDate strToDate(String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(YYYYMMDD));
    }
}
