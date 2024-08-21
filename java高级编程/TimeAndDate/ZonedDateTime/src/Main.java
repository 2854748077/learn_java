//withZoneSameINstant():时区转换
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.*;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {

        LocalDateTime ldt=LocalDateTime.of(2019,9,9,9,9,9);
        ZonedDateTime zdt1=ZonedDateTime.now();                                       // 默认时区
        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间
        ZonedDateTime zny2=ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime zny3=ldt.atZone(ZoneId.of("America/New_York"));
        LocalDateTime ldt1=zny3.toLocalDateTime();                                  //转换为localDataTime，丢弃时区
        //时区转换
        ZonedDateTime zny4=zny3.withZoneSameInstant(ZoneId.systemDefault());       //withZoneSameINstant()

        System.out.println(zny2);
        System.out.println(zny3);
        System.out.println("时区转换:"+zny4);



    }
}