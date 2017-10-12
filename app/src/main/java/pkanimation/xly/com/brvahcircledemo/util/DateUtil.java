package pkanimation.xly.com.brvahcircledemo.util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xuleyuan on 2017/10/12
 */

public class DateUtil {

    public static final String FULL_DATE_PATTERN_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String FULL_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String YEAR = "yyyy年";
    public static final String DYNAMICS = "yyyy年MM月dd日";
    public static final String MONTH = "MM月";
    public static final String FULL_TIME = "HH:mm";
    public static final String VIDEO_TIME = "MM-dd HH:mm";
    public static final String WITHIN_A_YEAR = "MM-dd HH:mm";
    public static final String PURCHASE_TIEM = "yyyy年MM月dd号";
    public static final String MONTH_AND_YEAR = "yyyy年MM月";
    public static final String MORE_THAN_A_YEAR = "yy-MM-dd HH:mm";
    public static final String RELATION_TIME = "yyyy.MM.dd";
    private static int serverDifference = 0;

    public static String getDataFormat(long formatTime) {
        String currentData = getCurrentTime();
        String formatData = getTime(formatTime);
        if (formatData.equals(currentData)) {
            return "今天";
        }
        String yestDay = getYesTodayDate();
        if (formatData.equals(yestDay)) {
            return "昨天";
        }
        String dynamics = getTime(formatTime, DYNAMICS);
        dynamics = dynamics.substring(2, dynamics.length());
        return dynamics;
    }

    /**
     * 得到昨天的日期
     *
     * @return
     */
    public static String getYesTodayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    }


    public static String getTime(long time, String pattern) {
        return getString(new Date(time), pattern);
    }

    public static String getTime(long time) {
        return getTime(time, DEFAULT_DATE_PATTERN);
    }

    public static String getCurrentTime() {
        return getCurrentTime(DEFAULT_DATE_PATTERN);
    }

    public static String getCurrentTime(String pattern) {
        return getString(new Date(), pattern);
    }

    public static String getString(Date date, String pattern) {
        String str = "";
        try {
            SimpleDateFormat sf = new SimpleDateFormat(pattern);
            str = sf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

}
