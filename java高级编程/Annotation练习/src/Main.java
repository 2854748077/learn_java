import java.lang.reflect.Field;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Person p1 = new Person("Bob", "Beijing", 20);
        Person p2 = new Person("", "Shanghai", 20);
        Person p3 = new Person("Alice", "Shanghai", 199);
        for (Person p : new Person[] { p1, p2, p3 }) {
            try {
                check(p);
                System.out.println("Person " + p + " checked ok.");
            } catch (IllegalArgumentException e) {
                System.out.println("Person " + p + " checked failed: " + e);
            }
        }
    }

    static void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
        for (Field field : person.getClass().getFields()) {                                         //获取类的Field，并遍历一遍
            Range range = field.getAnnotation(Range.class);                                         //获取class上的注解内容
            if (range != null) {
                Object value = field.get(person);                                                 //获取字段内容
                // TODO:
                if(value instanceof String ){                                                               //检测是否为String
                    if(value.toString().length()>range.max()||value.toString().length()<range.min()){       //判断
                        throw new IllegalArgumentException("过长或过短");                                        //抛出异常
                    };

                }if(value instanceof Integer){
                    if((int)value>range.max()||(int)value<range.min()){
                        throw new IllegalArgumentException("年龄不正常");
                    };

                }

            }
        }
    }
}

class Person {

    @Range(min = 1, max = 20)
    public String name;

    @Range(max = 10)
    public String city;

    @Range(min = 1, max = 100)
    public int age;

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("{Person: name=%s, city=%s, age=%d}", name, city, age);
    }
}

@Retention(RetentionPolicy.RUNTIME)                       //Retention（）：声明生存周期（运行时）
@Target(ElementType.FIELD)                              //Target（）：可用与字段上
 @interface Range {

    int min() default 0;

    int max() default 255;

}
