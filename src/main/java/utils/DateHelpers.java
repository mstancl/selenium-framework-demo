package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHelpers {

    public static String getCurrentDateYYYYMMDD() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return LocalDate.now().format(formatter);
    }

    public static String getCurrentDateMMMonthNameYYYYShort() {

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

        return (LocalDate.now().getDayOfMonth() < 10 ? "0" + LocalDate.now().getDayOfMonth() : LocalDate.now().getDayOfMonth()) + " " + monthName + " " + LocalDate.now().getYear();

    }

    public static int getCurrentDay() {
        return LocalDate.now().getDayOfMonth();
    }

    public static int getCurrentYear() {
        return LocalDate.now().getYear();
    }

    public static String getCurrentMonthName() {

        String monthName = null;

        switch (LocalDate.now().getMonth()) {
            case JANUARY:
                monthName = "January";
                break;
            case FEBRUARY:
                monthName = "February";
                break;
            case MARCH:
                monthName = "March";
                break;
            case APRIL:
                monthName = "April";
                break;
            case MAY:
                monthName = "May";
                break;
            case JUNE:
                monthName = "June";
                break;
            case JULY:
                monthName = "July";
                break;
            case AUGUST:
                monthName = "August";
                break;
            case SEPTEMBER:
                monthName = "September";
                break;
            case OCTOBER:
                monthName = "October";
                break;
            case NOVEMBER:
                monthName = "November";
                break;
            case DECEMBER:
                monthName = "December";
                break;

        }

        return monthName;

    }

}
