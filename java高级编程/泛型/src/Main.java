import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> al=new ArrayList<>();
        List<Integer> list1=al;                  //向上转型。 转型：<?> ?不能改变
        person[] ps=new person[]{
            new person("Ben",16),
                new person("Tony",23),
                new person("LiHua",33),
        };
        Arrays.sort(ps);                              //复写compareTo()方法实现对比
        System.out.println(Arrays.toString(ps));


        student<String>  st1=new student<>();          //实例化泛型类
        System.out.println(st1.getGrate("一年级"));
        student.setGrate("hello");                     //调用泛型静态方法

    }

}

class person implements Comparable<person> {          //implements 接口Comparable<类名>，然后重写comparable可以实现类名之间的对比
    public String Name;
    public int Score;
    public person(String name ,int Score){
        this.Name=name;
        this.Score=Score;
    }
    public int compareTo(person other) {                            //重写compareTo(): 用来给person对象作对比
        return this.Name.compareTo(other.Name);
    }

    public String toString(){
        System.out.println("姓名："+this.Name+"成绩"+this.Score);
        return this.Name+","+this.Score;
    }
}
/*
Java的泛型是采用擦拭法实现的；

擦拭法决定了泛型<T>：

不能是基本类型，例如：int；
不能获取带泛型类型的Class，例如：Pair<String>.class；
不能判断带泛型类型的类型，例如：x instanceof Pair<String>；
不能实例化T类型，例如：new T()。
泛型方法要防止重复定义方法，例如：public boolean equals(T obj)；

子类可以获取父类的泛型类型<T>。

                      ┌────┐
                      │Type│
                      └────┘
                         ▲
                         │
   ┌────────────┬────────┴─────────┬───────────────┐
   │            │                  │               │
┌─────┐┌─────────────────┐┌────────────────┐┌────────────┐
│Class││ParameterizedType││GenericArrayType││WildcardType│
 */
