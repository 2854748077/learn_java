
/*@Override：让编译器检查该方法是否正确地实现了覆写；
@SuppressWarnings：告诉编译器忽略此处代码产生的警告。*/

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.lang.annotation.*;

//自定义
public class Main {
    public static void main(String[] args) {


        System.out.println(hello.class.isAnnotationPresent(Report.class));


        }
    }


/*
@Target
类或接口：ElementType.TYPE；
字段：ElementType.FIELD；
方法：ElementType.METHOD；
构造方法：ElementType.CONSTRUCTOR；

@Rentention
方法参数：ElementType.PARAMETER。
仅编译期：RetentionPolicy.SOURCE；
仅class文件：RetentionPolicy.CLASS；
运行期：RetentionPolicy.RUNTIME。

@Repeatable
使用这个元注解可以定义Annotation是否可重复
*/

//@Repeatable()//  经过@Repeatable修饰后，在某个类型声明处，就可以添加多个@Report注解：
@Inherited    //定义子类可以继承父类annotation
@Retention (RetentionPolicy.RUNTIME)                      //Retention():定义注解生命周期
@Target({ElementType.METHOD,ElementType.FIELD})          //Target():可用在方法上，字段上
@interface Report   {              //自定义注解
    int type() default 0;       //default:默认值
    String Value() default "info";
}

/**/

class hello{
    int type=1;
    @Report(type=1,Value ="贵")          // 使用注解
   // @Report(type = 2,Value = "贵吗")      //经@Repetable修饰可以添加多个相同注解
    public void hello1(){};

}