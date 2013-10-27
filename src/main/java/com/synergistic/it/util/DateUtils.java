package com.synergistic.it.util;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author astha
 *
 */
public class DateUtils {

    public static Time getCurrentTime() {
        //setting the values inside the queries
        Date date = new Date();
        long d = date.getTime();
        Time time = new Time(d);
        return time;
    }
    
    /**
     * Method which return the current date
     *
     * @return
     */
    public static java.sql.Date getFromDateDateInSQLFormat(String cdate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String cdateInString = formatter.format(cdate);
        DateFormat dformatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = null;
        try {
            javaDate = dformatter.parse(cdateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date cSQLDate = new java.sql.Date(javaDate.getTime());
        return cSQLDate;
    }

    /**
     * Method which return the current date
     *
     * @return
     */
    public static java.sql.Date getCurrentDateInSQLFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String cdateInString = formatter.format(new Date());
        DateFormat dformatter = new SimpleDateFormat("yyyy-MM-dd");
        Date javaDate = null;
        try {
            javaDate = dformatter.parse(cdateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date cSQLDate = new java.sql.Date(javaDate.getTime());
        return cSQLDate;
    }

    public static String getMonthName(int index) {
        String montharr[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL",
            "AUG", "SEP", "OCT", "NOV", "DEC"};
        return montharr[index];
    }

    /**
     * get current date in dd-MMM-yyyy format 26-MAY-2013
     *
     * @return
     */
    public static String getCurrentDate() {
        // //////this is for date purpose
        String month, dd, year;
        Calendar cnd;
        String montharr[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL",
            "AUG", "SEP", "OCT", "NOV", "DEC"};
        String datearr[] = {"01", "02", "03", "04", "05", "06", "07", "08",
            "09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
            "29", "30", "31"};
        cnd = Calendar.getInstance();
        dd = datearr[cnd.get(Calendar.DATE) - 1];
        month = montharr[cnd.get(Calendar.MONTH)];
        year = "" + cnd.get(Calendar.YEAR);
        String sysdate = "" + dd + "-" + month + "-" + year;
        return sysdate;
    }

    public static String convertDateIntoString(Date date) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");
        return myFormat.format(date);
    }
    
      public static Date convertStringFromddMMYYYYIntoDate(String date){
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date dd = null;
        try {
            dd = myFormat.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return dd;
    }
    
    public static Date convertMMMYYIntoDateFormat(String date){
        date="01-"+date;
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-dddd");
        Date dd = null;
        try {
            dd = myFormat.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return dd;
    }

    public static Date convertStringIntoDateYYMMDD(String date) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dd = null;
        try {
            dd = myFormat.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return dd;
    }

    public static Date convertStringIntoDate(String date) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date dd = null;
        try {
            dd = myFormat.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return dd;
    }

    public static String convertddMMFormat(String inputString) {
        SimpleDateFormat fromUser = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = null;
        try {
            date = fromUser.parse(inputString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return myFormat.format(date);
    }
}
