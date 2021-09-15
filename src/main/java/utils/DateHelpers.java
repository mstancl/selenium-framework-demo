package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelpers {

    public static String getCurrentDateYYYYMMDD() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.now().format(formatter);
    }

    public static String getCurrentDateMMMonthNameYYYY() {

        String monthName = null;

        switch (LocalDate.now().getMonth()) {
            case JANUARY:
                monthName = "Jan";
                break;
            case FEBRUARY:
                monthName = "Feb";
                break;
            case MARCH:
                monthName = "Mar";
                break;
            case APRIL:
                monthName = "Apr";
                break;
            case MAY:
                monthName = "May";
                break;
            case JUNE:
                monthName = "Jun";
                break;
            case JULY:
                monthName = "Jul";
                break;
            case AUGUST:
                monthName = "Aug";
                break;
            case SEPTEMBER:
                monthName = "Sep";
                break;
            case OCTOBER:
                monthName = "Oct";
                break;
            case NOVEMBER:
                monthName = "Nov";
                break;
            case DECEMBER:
                monthName = "Dec";
                break;

        }

        return LocalDate.now().getDayOfMonth() + " " + monthName + " " + LocalDate.now().getYear();

    }

}
