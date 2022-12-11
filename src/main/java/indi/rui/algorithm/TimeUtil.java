package indi.rui.algorithm;

/**
 * @author: yaowr
 * @create: 2022-12-11
 */
public class TimeUtil {


    public static String getDuration(long milli) {
        long second = milli / 1000;
        long minutes = second / 60;
        StringBuilder builder = new StringBuilder();
        if (minutes > 0) {
            builder.append(minutes + "分");
        }
        if (second > 0) {
            builder.append(second % 60 + "秒");
        }
        builder.append(milli % 1000 + "毫秒");
        return builder.toString();
    }
}
