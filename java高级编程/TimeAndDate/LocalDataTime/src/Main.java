import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import static java.lang.Thread.sleep;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {

        LocalDate ld=LocalDate.now();
        LocalTime lt=LocalTime.now();// 当前时间
        LocalDateTime ldt=LocalDateTime.now();// 当前日期和时间
        System.out.println("时间"+lt+"\n日期"+ld+"\n时间日期"+ldt);//严格按照ISO 8601格式打印

        LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
        LocalDate q = dt.toLocalDate(); // 转换到当前日期
        LocalTime t = dt.toLocalTime(); // 转换到当前时间

        LocalDate ld1=LocalDate.of(1999,9,9);    //.of():方法创建LocalDateTime
        System.out.println(ld1);

        LocalDateTime dt1 = LocalDateTime.parse("2019-11-19T15:16:17");  //parse(String s):创建
        LocalDate d1 = LocalDate.parse("2019-11-19");
        LocalTime t1 = LocalTime.parse("15:16:17");
//*********************************************************************************************************************************************
        //自定义格式化
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   //自定义格式化
        LocalDateTime dt2=LocalDateTime.parse("2019-10-11 12:12:12",dateTimeFormatter);  //自定义格式解析

        System.out.println("\n"+dt2);  //1999-09-09
        System.out.println(dt2.plusDays(5).minusYears(9));   //加5天减9年     2010-10-16
                                                            //plus**（）：增加 ，minus（）：减少
        System.out.println(dt2.withYear(2000));             //whit**():调整（就是直接修改）

        //***********************************************************************************************************************
        //with()方法的复杂用法
        // 本月第一天0:00时刻:
        LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        System.out.println(firstDay);
        // 本月最后1天:
        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);
        // 下月第1天:
        LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(nextMonthFirstDay);
        // 本月第1个周一:
        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstWeekday);
        //********************************************************************************************************************
        //判断时间先后

        LocalTime l1=LocalTime.now();
        try {
            sleep(100);
        }catch (InterruptedException e){}
        LocalTime l2=LocalTime.now();
        System.out.println(l1.isBefore(l2));  //true    //isBefore():xx是xx之前的时间
        System.out.println(l1.isAfter(l2));   //false   // isAfter():xx是xx之后的时间
        //***************************************************************************************************************
        //时间间隔和两个日期之间天数
        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
        Duration d = Duration.between(start, end);          //Duration.between():两个时间的时间间隔
        System.out.println(d); // PT1235H10M30S  表示1235小时10分钟30秒

        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));        //两个日期之间的天数        System.out.println(p); // P1M21D
        System.out.println(p); // P1M21D  1个月21天
        Duration d3 = Duration.ofHours(10); // 10 hours
        Duration d4 = Duration.parse("P1DT2H3M"); // 1 day, 2 hours, 3 minutes
    }
}