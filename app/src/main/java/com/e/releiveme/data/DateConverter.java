package com.e.releiveme.data;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {

        @TypeConverter
        public static Date fromTimestamp(Long value) {
            return value == null ? null : new Date(value);
        }

        @TypeConverter
        public static Long dateToTimestamp(Date date) {
            return date == null ? null : date.getTime();
        }
        public static String dateToString(long date){
            DateFormat fullDateFormat=new SimpleDateFormat("EEE dd MMM  yyyy\nhh:mm ",
                    Locale.FRANCE);
            return fullDateFormat.format(DateConverter.fromTimestamp((long)date*1000));

        }


}
