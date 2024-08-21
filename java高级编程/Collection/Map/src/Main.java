/*
* put(): 将key和value做映射，放入map中
* get():通过key找value
* containsKey(): 查询某个key是否存在
* 通过entrySet（）：方法获取key和value
*
* 要正确使用HashMap，作为key的类必须正确覆写equals()和hashCode()方法；
一个类如果覆写了equals()，就必须覆写hashCode()，并且覆写规则是：
如果equals()返回true，则hashCode()返回值必须相等；
如果equals()返回false，则hashCode()返回值尽量不要相等。
实现hashCode()方法可以通过Objects.hashCode()辅助方法实现。
* */
import java.time.DayOfWeek;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Student st = new Student("豪",100);
        Map<String,Student> map =new HashMap<>();
        map.put("豪",st);                                     //put(): 将key和value做映射，放入map中
        map.put("小明",st);
        System.out.println("key不存在返回："+map.get("不存在")); //返回null
        Student target=map.get("豪");                        //get():通过key找value
        System.out.println(map.containsKey("豪"));           //containsKey(): 查询某个key是否存在
        System.out.println(target==st);
        System.out.println(target.score+"   "+st.score);
        for(String s:map.keySet()){                         //keySet（）：遍历Map
            System.out.println(map.get(s));
        }
        for (Map.Entry<String,Student>entry:map.entrySet()){           //通过entrySet（）：方法获取key和value
            System.out.println(" Key\t:"+entry.getKey()+" value\t："+entry.getValue());
        }

        Map<DayOfWeek, String> map1 = new EnumMap<>(DayOfWeek.class);   //EnumMap(Class<K> keyType) :根据Enum内部类型直接找到索引
        map1.put(DayOfWeek.MONDAY, "星期一");
        map1.put(DayOfWeek.TUESDAY, "星期二");
        map1.put(DayOfWeek.WEDNESDAY, "星期三");
        map1.put(DayOfWeek.THURSDAY, "星期四");
        map1.put(DayOfWeek.FRIDAY, "星期五");
        map1.put(DayOfWeek.SATURDAY, "星期六");
        map1.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println(map1);
        System.out.println(map1.get(DayOfWeek.MONDAY));
//********************************************************************************************************************************************8
        Map<Student,Integer> treemap=new TreeMap<>(/*new Comparator<Student>() {              //key类没有实现comparable接口，要在创建Treemap时指定一个自定义排序算法
            public int compare(Student p1, Student p2) {
                return p1.name.compareTo(p2.name);
            }
        }*/);
        treemap.put(new Student("apple",10),1);
        treemap.put(new Student("cat",20),2);
        treemap.put(new Student("banana",30),3);
        for (Student key : treemap.keySet()) {
            System.out.println(key.name+"     **********     "+treemap.get(key));   //按字母默认排序
        }

    }
}

class Student implements Comparable<Student>{
    public String name;
    public int score;
    int i;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public int compareTo(Student other){               //覆写compareTo（）: TreeMap必须覆写该方法
        System.out.println(this.name+"  "+other.name+"     "+this.name.compareTo(other.name));             //负责比较传入的两个元素a和b，如果a<b，则返回负数，通常是-1，如果a==b，则返回0，如果a>b，则返回正数，通常是1
        return this.name.compareTo(other.name);

    }



}class person{
    public String firstName;
    public String lastName;
    public   int age;
    public boolean equals(Object obj){                 //equals 中出现比较的字段必须也出现在hashCode（）
        if(obj instanceof person){
            if(this.age==((person) obj).age&& Objects.equals(this.firstName, ((person) obj).firstName) &&this.lastName.equals(((person) obj).lastName)){
                return true;
            }
        }
        return false;

    }
    @Override
    public int hashCode(){                             //equals中没有比较的字段不能出现在hashCode
     int h=0;
     h=31*h+firstName.hashCode();             //返回一个哈希码
     h=31*h+lastName.hashCode();
     h=31*h+age;
     return h;
    }


}
//小结
/*
*
要正确使用HashMap，作为key的类必须正确覆写equals()和hashCode()方法；
一个类如果覆写了equals()，就必须覆写hashCode()，并且覆写规则是：
如果equals()返回true，则hashCode()返回值必须相等；
如果equals()返回false，则hashCode()返回值尽量不要相等。
实现hashCode()方法可以通过Objects.hashCode()辅助方法实现。
* */