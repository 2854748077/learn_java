public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        if (day == Weekday.SAT || day == Weekday.SUN) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
        Weekday x=Weekday.SUN;
        int n=x.ordinal();                   //返回定义常数的顺序。 0 开始
        System.out.println();
    }
}

enum Weekday {
    SUN, MON, TUE, WED, THU, FRI, SAT;
}
/*
* 小结
Java使用enum定义枚举类型，它被编译器编译为final class Xxx extends Enum { … }；
通过name()获取常量定义的字符串，注意不要使用toString()；
通过ordinal()返回常量定义的顺序（无实质意义）；
可以为enum编写构造方法、字段和方法
enum的构造方法要声明为private，字段强烈建议声明为final；
enum适合用在switch语句中。
* */