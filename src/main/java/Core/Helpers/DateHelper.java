package Core.Helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    public String getTodayDate(String dateFormat) {
        SimpleDateFormat simpleDate = new SimpleDateFormat(dateFormat);
        Date currentDate = new Date();
        String date = simpleDate.format(currentDate);
        return date;
    }

    public String getFutureDate(int addedYears, int addedMonths, int addedDays, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date currentDate = new Date();

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
        c.add(Calendar.YEAR, addedYears);
        c.add(Calendar.MONTH, addedMonths);
        c.add(Calendar.DATE, addedDays);

        // convert calendar to date
        Date currentDatePlus = c.getTime();
        return dateFormat.format(currentDatePlus);
    }

    public String getRequiredDayDate(int days, String dateFormat){
        SimpleDateFormat simpleDate = new SimpleDateFormat(dateFormat);
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, days);
        currentDate = c.getTime();
        return  simpleDate.format(currentDate);
    }
}
