

import java.lang.reflect.Method;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String name = "Xiao Ming";
        int age = 20;
        Person p = new Person();
        // TODO: 利用反射调用setName和setAge方法:
        Class class1=p.getClass();
        Method method1=class1.getMethod("setName",String.class);
        Method method2=class1.getMethod("setAge", int.class);
        method1.invoke(p, "哈哈");
        method2.invoke(p, 10);
        System.out.println(p.getAge()+"  "+p.getName());

        System.out.println(p.getName()); // "Xiao Ming"
        System.out.println(p.getAge()); // 20
    }
}

class Person {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
