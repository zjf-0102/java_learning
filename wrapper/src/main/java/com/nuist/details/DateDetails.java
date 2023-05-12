package com.nuist.details;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateDetails {
    public static void main(String[] args) {
        /*
        第一代日期类Date
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        String s = simpleDateFormat.format(new Date());

        /*
        第二代日期类Calendar
         */
        //Calendar是个接口，并且构造器是protected，不能new
        Calendar c = Calendar.getInstance();
        c.get(Calendar.YEAR);

        /*
        第三代日期类LocalDate,LocalTime,LocalDateTime
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        formatter.format(localDateTime);
    }
}
