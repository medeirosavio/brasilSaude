package io.github.medeirosavio.util;

import java.time.LocalDate;
public class DatePastValidator {

    public static boolean isPastDate(LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        return date.isBefore(currentDate);
    }

}
