// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
//toLowerCase() :返回一个大写字母都转为小写字母的字符串
//equalsIgnoreCase():要忽略大小写比较
//contains():查看是否包含子串
//trim()去除字符串首尾空白字符
//strip()去除字符串首尾空白字符以及中文空格字符\U3000
//str1.isEmpty():字符串是否为空
//str1.isBlank()：是否为空白字符串
//str1.replace()：字符串替换
//str1.replaceAll():正则表达式替换字符串
//spilt();传入正则表达式，分割字符串
//String.join():拼接字符串
//formatted():通过传入参数构建新字符串
//format():通过传入参数构建新字符串
//String.valueOf():转换为字符串形式
//parseInt():String转Int
//parseBoolean():String转boolean
//getBytes():转换编码

//StringBuilder
//append(): 拼接新的内容到数组里
public class Main {
    public static void main(String[] args) {

        String str1="    hello world \n";
        String str2="HELLO WORLD".toLowerCase();
        boolean b = str2==str1;
        System.out.println("=:"+b);                          //false
        System.out.println(".equals:"+str1.equals(str2));    //true //字符串比较必须要equals（）方法

        System.out.println("是否包含子串："+str1.contains("wor"));  //true //是否包含子串
        System.out.println("是否包含子串："+str1.lastIndexOf("l"));  //9
        System.out.println("是否包含子串："+str1.startsWith("he"));  //true
        System.out.println("是否包含子串："+str1.endsWith("ld"));      //true

        System.out.println(str1+"\t去除字符串首尾字符：\n"+str1.trim());  //trim()去除字符串首尾空白字符
        System.out.println(str1+"\t去除字符串首尾字符：\n"+str1.strip()); //strip()去除字符串首尾空白字符以及中文空格字符\U3000
        System.out.println("字符串是否为空："+str1.isEmpty()+"是否为空白字符串："+str1.isBlank());

        System.out.println("原子串"+str1+"替换子串:"+str1.replace("l","o")+"正则表达式替换"+str1.replaceAll("[\\,\\;\\s]+", ","));

        String[] strings=str1.split("\s");
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]);
        }
        String st3=String.join("*",strings);
        System.out.println("拼接字符串后:"+st3);

        String s = "Hi %s, your score is %d!";
        System.out.println(s.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));

        //类型转换
        String.valueOf(123);    //任意类型转换为字符串形式

        int n1 = Integer.parseInt("123"); // 123

        char[] cs = "Hello".toCharArray(); // String -> char[]
        String s1 = new String(cs); // char[] -> String

        byte[] b1 = "Hello".getBytes();    //getBytes():转换编码

        StringBuilder sb =new StringBuilder(100);
        sb.append("1").append("2").append("31");      //append():拼接新的字段到StringBuilder上
        System.out.println(sb);
    }
}