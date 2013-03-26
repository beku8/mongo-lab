package com.fm.mongotrip.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	private static SimpleDateFormat displayFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	
    /**
     * Өдрийн зөрүүг бодох алгоритм
     * Өдрийн байрлал хамаарахгүй эерэг утга буцаана.
     * @param date1 - дурын
     * @param date2 - дурын
     * @return
     */
    public static Integer getDaysBetween(Date date1, Date date2){
        return getDaysBetween(date1, date2, false);
    }

    /**
     * Өдрийн зөрүүг бодох алгоритм
     * Өдрийн байрлал хамаарна.
     * @param date1
     * @param date2
     * @param isOrdered true - байвал байрлал хамаарна.
     * @return
     */
    public static Integer getDaysBetween(Date date1, Date date2, Boolean isOrdered){
        Calendar d1 = Calendar.getInstance();
        Calendar d2 = Calendar.getInstance();
        d1.setTime(date1);
        d2.setTime(date2);
        if(!isOrdered){
            if (d1.after(d2)) {
                java.util.Calendar swap = d1;
                d1 = d2;
                d2 = swap;
            }
        }
        int days = d2.get(java.util.Calendar.DAY_OF_YEAR) -
                   d1.get(java.util.Calendar.DAY_OF_YEAR);
        int y2 = d2.get(java.util.Calendar.YEAR);
        if (d1.get(java.util.Calendar.YEAR) != y2) {
            d1 = (java.util.Calendar) d1.clone();
            do {
                days += d1.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
                d1.add(java.util.Calendar.YEAR, 1);
            } while (d1.get(java.util.Calendar.YEAR) != y2);
        }
        return days;
    }
    
    /**
     * @param dateString formatted yyyy-MM-dd
     * @return
     */
    public static Date parseISO(String dateString){
        try {
            Date date = displayFormat.parse(dateString);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
