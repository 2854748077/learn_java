import java.util.List;

//给Person类增加equals方法，使得调用indexOf()方法返回正常：
public class Main {
    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("Xiao", "Ming", 18),
                new Person("Xiao", "Hong", 25),
                new Person("Bob", "Smith", 20)
        );
        boolean exist = list.contains(new Person("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");

    }
}

class Person {
    String firstName;
    String lastName;
    int age;
    public Person(){};
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public  boolean equals(Object obj){     //覆写方法：equals（Object obj）
       Person p=new Person();
        if (obj instanceof Person) {                //判断是否可以安全转型
            p = (Person) obj;
        }return this.age == p.age && this.firstName.equals(p.firstName) && this.lastName.equals(p.lastName);
    }

}
