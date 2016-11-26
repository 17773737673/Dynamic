package recycle.com.example.nandy.dynamicdemo.utils;

import android.annotation.SuppressLint;
import android.content.Context;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import recycle.com.example.nandy.dynamicdemo.R;

/**
 * 日期工具类
 * Created by bob on 2015/2/28.
 */
public class DateUtils {

    private static String format2;

    @SuppressLint("DefaultLocale")
    public static String getFormattedTime(Context context, long ts) {
        String s = "";
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis((long) (ts) * 1000);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        String week[] = context.getResources().getStringArray(R.array.week);
        if (isToday(ts)) {
            if (hour <= 5) {
                s = String.format(context.getString(R.string.message_today_before_dawn_format), hour, minute);
            } else if (hour <= 11) {
                s = String.format(context.getString(R.string.message_today_am_format), hour, minute);
            } else if (hour == 12) {
                s = String.format(context.getString(R.string.message_today_pm_format), hour, minute);
            } else {
                hour -= 12;
                if (hour <= 5) {
                    s = String.format(context.getString(R.string.message_today_pm_format), hour, minute);
                } else {
                    s = String.format(context.getString(R.string.message_today_night_format), hour, minute);
                }
            }
        } else if (isYesterday(ts)) {
            s = String.format(context.getString(R.string.message_yesterday_format), hour, minute);
        } else if (isInWeek(ts)) {
            s = String.format("%s %02d:%02d", week[dayOfWeek - 1], hour, minute);
        } else if (isInYear(ts)) {
            s = String.format("%02d-%02d %02d:%02d", month + 1, dayOfMonth, hour, minute);
        } else {
            s = String.format("%d-%02d-%02d %02d:%02d", year, month + 1, dayOfMonth, hour, minute);
        }
        return s;
    }


    @SuppressLint("DefaultLocale")
    public static String getFormattedTime2(long ts, Context instance) {
        String s = "";
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(ts * 1000);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        if (isToday(ts)) {
            s = instance.getString(R.string.today);
        } else if (isYesterday(ts)) {
            s = instance.getString(R.string.yesterday);
        } else {
            s = String.format("%02d-%02d", month + 1, dayOfMonth);
        }
        return s;
    }

    private static boolean isToday(long ts) {
        int now = now();
        return isSameDay(now, ts);
    }

    private static boolean isYesterday(long ts) {
        int now = now();
        int yesterday = now - 24 * 60 * 60;
        return isSameDay(ts, yesterday);
    }

    private static boolean isInWeek(long ts) {
        int now = now();
        //6天前
        long day6 = now - 6 * 24 * 60 * 60;
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(day6 * 1000);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        int zero = (int) (cal.getTimeInMillis() / 1000);
        return (ts >= zero);
    }

    private static boolean isInYear(long ts) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(ts * 1000);
        int year = cal.get(Calendar.YEAR);

        cal.setTime(new Date());
        int y = cal.get(Calendar.YEAR);

        return (year == y);
    }

    private static boolean isSameDay(long ts1, long ts2) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(ts1 * 1000);
        int year1 = cal.get(Calendar.YEAR);
        int month1 = cal.get(Calendar.MONTH);
        int day1 = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTimeInMillis(ts2 * 1000);
        int year2 = cal.get(Calendar.YEAR);
        int month2 = cal.get(Calendar.MONTH);
        int day2 = cal.get(Calendar.DAY_OF_MONTH);

        return ((year1 == year2) && (month1 == month2) && (day1 == day2));
    }

    public static int now() {
        Date date = new Date();
        long t = date.getTime();
        return (int) (t / 1000);
    }

    public static String getFormattedDate(long timeMills, String strFormat) {
        SimpleDateFormat format = new SimpleDateFormat(strFormat);
        Date date = new Date(timeMills);
        return format.format(date);
    }

    public static String getFormat(long timeMills, String strFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
        try {
            Date parse = dateFormat.parse(String.valueOf(timeMills));
            format2 = parse.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format2;
    }

    /**
     * 得到当前时间
     *
     * @param dateFormat 时间格式
     * @return 转换后的时间格式
     */
    public static String getStringToday(String dateFormat) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.getDefault());
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 将字符串型日期转换成日期
     *
     * @param dateStr    字符串型日期
     * @param dateFormat 日期格式
     * @return
     */
    public static Date stringToDate(String dateStr, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.getDefault());
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String dateToString(Date date, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }

    /**
     * 两个时间点的间隔时长（分钟）
     *
     * @param before 开始时间
     * @param after  结束时间
     * @return 两个时间点的间隔时长（分钟）
     */
    public static long compareMin(Date before, Date after) {
        if (before == null || after == null) {
            return 0l;
        }
        long dif = 0;
        if (after.getTime() >= before.getTime()) {
            dif = after.getTime() - before.getTime();
        } else if (after.getTime() < before.getTime()) {
            dif = after.getTime() + 86400000 - before.getTime();
        }
        dif = Math.abs(dif);
        return dif / 60000;
    }

    /**
     * 获取指定时间间隔分钟后的时间
     *
     * @param date 指定的时间
     * @param min  间隔分钟数
     * @return 间隔分钟数后的时间
     */
    public static Date addMinutes(Date date, int min) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, min);
        return calendar.getTime();
    }

}
