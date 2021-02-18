package com.e.releiveme.data;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {

        @TypeConverter
        public static Date fromTimestamp(Long value) {
            return value == null ? null : new Date(value*1000);
        }

        @TypeConverter
        public static Long dateToTimestamp(Date date) {
            return date == null ? null : date.getTime();
        }
        public static String dateToString(long date){
            DateFormat fullDateFormat=new SimpleDateFormat("EEE dd MMM  yyyy\nHH:mm ",
                    Locale.FRENCH);
            return fullDateFormat.format(DateConverter.fromTimestamp(date));

        }


}
