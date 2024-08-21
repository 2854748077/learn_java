
//add():时间加减运算



import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //******************************************************************************************
        //Date
        Date date=new Date();
        System.out.println(date.getYear()+1900);   //必须加上1900，已不用
        System.out.println(date.getMonth()+1);
        System.out.println(date.getDate());

        System.out.println(date.toString());
        System.out.println(date.toGMTString());
        //
        //*********************************************************************************************
        //calendar
        Calendar calendar=Calendar.getInstance();    //唯一一种获取方式
        System.out.println(calendar.get(Calendar.YEAR));     //get(Field): 获取信息
        System.out.println(calendar.get(Calendar.MONDAY)+1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        int y = calendar.get(Calendar.YEAR);
        int m = 1 + calendar.get(Calendar.MONTH);
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        int w = calendar.get(Calendar.DAY_OF_WEEK); //星期日是第一天
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        int mm = calendar.get(Calendar.MINUTE);
        int ss = calendar.get(Calendar.SECOND);         //秒
        int ms = calendar.get(Calendar.MILLISECOND); //毫秒
        System.out.println(y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);

        //设置特定日期，必须先清除所有字段
        calendar.clear();
        calendar.set(Calendar.YEAR,1999);
        calendar.set(Calendar.MONDAY,8);
        calendar.set(Calendar.DAY_OF_WEEK,4);
        System.out.println(calendar.getTime());
        // 当前时间:
        Calendar c = Calendar.getInstance();
        // 清除所有:
        c.clear();
        // 设置2019年:
        c.set(Calendar.YEAR, 2019);
        // 设置9月:注意8表示9月:
        c.set(Calendar.MONTH, 8);
        // 设置2日:
        c.set(Calendar.DATE, 2);
        // 设置时间:
        c.set(Calendar.HOUR_OF_DAY, 21);
        c.set(Calendar.MINUTE, 22);
        c.set(Calendar.SECOND, 23);
        //利用Calendar.getTime()可以将一个Calendar对象转换成Date对象，然后就可以用SimpleDateFormat进行格式化了。
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime()));////利用Calendar.getTime()可以将一个Calendar对象转换成Date对象，然后就可以用SimpleDateFormat进行格式化了
        // 2019-09-02 21:22:23
//********************************************************************************************************************8
        //TimeZone
        System.out.println("******************************************************************************************");
        TimeZone tzDefault=TimeZone.getDefault();//当前时区
        TimeZone tzGMT9=TimeZone.getTimeZone("GMT+09:00");
        TimeZone tzNY=TimeZone.getTimeZone("America/New_york");
        System.out.println(tzDefault.getID());
        System.out.println(tzGMT9.getID()); // GMT+09:00
        System.out.println(tzNY.getID()); // America/New_York
        //***************************************************************************************************************
        //练习时区转换
        Calendar e=Calendar.getInstance();
        e.clear();
        e.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        e.set(2019,10,20,8,15,0);
        var sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //本质上时区转换只能通过SimpleDateFormat在显示的时候完成。
        System.out.println("Asia/Shanghai:"+sdf.format(e.getTime()));

        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println("America/New_York:"+sdf.format(e.getTime()));

        //时间加减法
        e.add(Calendar.MONTH,6);
        e.add(Calendar.YEAR,5);
        System.out.println("America/New_York:"+sdf.format(e.getTime()));



/*        Calendar r = Calendar.getInstance();
        // 清除所有:
        r.clear();
        // 设置为北京时区:
        r.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        // 设置年月日时分秒:
        r.set(2019, 10 , 20, 8, 15, 0);
        // 显示时间:
        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(sdf.format(r.getTime()));*/

    }
}