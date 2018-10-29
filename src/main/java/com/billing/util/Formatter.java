package com.billing.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter
{
    final private  static SimpleDateFormat FORMART_DD_MM_YYYY = new SimpleDateFormat("dd/MM/yyyy");
    final private  static SimpleDateFormat FORMART_DD_MM_YYYY_HH_MM_SS = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static String DateFormatter(Date dt)
    {
        return FORMART_DD_MM_YYYY.format(dt);
    }
    public static String DateFormatterWithTime(Date dt)
    {
        return FORMART_DD_MM_YYYY_HH_MM_SS.format(dt);
    }

    public static String StringFormatterLeftPad(String text, int length)
    {
        return String.format("%" + length + "." + length + "s", text);
    }

    public static String StringFormatterRightPad(String text, int length)
    {
        return String.format("%-" + length + "." + length + "s", text);
    }

    public static double getDecimalFormat(double d)
    {
        DecimalFormat df =new DecimalFormat("#.##");
        return Double.parseDouble(df.format(d));
    }


}
