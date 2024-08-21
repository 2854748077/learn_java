/*
\d:匹配数字
单个字符的匹配规则如下：

正则表达式	规则	可以匹配
A	指定字符	A
\u548c	指定Unicode字符	和
.	任意字符	a，b，&，0
\d	数字0~9	0~9
\w	大小写字母，数字和下划线	a~z，A~Z，0~9，_
\s	空格、Tab键	空格，Tab
\D	非数字	a，A，&，_，……
\W	非\w	&，@，中，……
\S	非\s	a，A，&，_，……
多个字符的匹配规则如下：

正则表达式	规则	可以匹配
A*	任意个数字符	空，A，AA，AAA，……
A+	至少1个字符	A，AA，AAA，……
A?	0个或1个字符	空，A
A{3}	指定个数字符	AAA
A{2,3}	指定范围个数字符	AA，AAA
A{2,}	至少n个字符	AA，AAA，AAAA，……
A{0,3}	最多n个字符	空，A，AA，

复杂匹配规则主要有：

正则表达式	规则	可以匹配
^	开头	字符串开头
$	结尾	字符串结束
[ABC]	[…]内任意字符	A，B，C
[A-F0-9xy]	指定范围的字符	A，……，F，0，……，9，x，y
[^A-F]	指定范围外的任意字符	非A~F
AB|CD|EF	AB或CD或EF	AB，CD，EF

正则表达式用(...)分组可以通过Matcher对象快速提取子串：

group(0)表示匹配的整个字符串；
group(1)表示第1个子串，group(2)表示第2个子串，以此类推。

？ ： 非贪婪匹配
* */
package thread.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {

        //匹配电话
        String iphone="(^[1-9]{3,4})-([0-9]{7,8})";        //3~4位区号加7~8位电话
        System.out.println("1339-2369471".matches(iphone));
        Pattern pattern=Pattern.compile(iphone);           //编译pattern
        System.out.println("111111111"+pattern.matcher("1234-5678911").matches());
        Matcher matcher=pattern.matcher("1382-7044739");        //与pattern匹配
        if(matcher.matches()){
            System.out.println(matcher.group(1)+"  ***  "+matcher.group(2));            //提取分组
        }

        String re="^learn\\s([pP]hp|[jJ]ava|[gG]o)$";
        System.out.println("learn Php".matches(re));
        System.out.println("learn java".matches(re));
        System.out.println("learn Java".matches(re));
        System.out.println("learn php".matches(re));
        System.out.println("learn Go".matches(re));

        Pattern pattern1 = Pattern.compile("(\\d+?)(0*)");    //?非贪婪匹配，尽可能少的匹配
        Matcher matcher2 = pattern1.matcher("1230000");
        if (matcher2.matches()) {
            System.out.println("group1=" + matcher2.group(1)); // "123"
            System.out.println("group2=" + matcher2.group(2)); // "0000"
        }

        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\w*o\\w*");           //设置pattern
        Matcher m = p.matcher(s);                                //放入Matcher
        while (m.find()) {                                      //find（）：m中按照pattern寻找下一个字串,判断是否为空. 返回boolean
            System.out.println(m.start()+"***"+m.end());
            String sub = s.substring(m.start(), m.end());       //start（），end（）：返回开始下标和结束下标
            System.out.println(sub);
        }
    }
}