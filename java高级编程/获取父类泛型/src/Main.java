import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Pair<Integer>[] ps = (Pair<Integer>[]) new Pair[2];            //通过强制转型实现泛型数组
        String[] string1=(String[])asArray("可变参数","实现数组");  //可变参数实现泛型数组
        System.out.println(Arrays.toString(string1));

        Class<IntPair> clazz = IntPair.class;                          //（1）获取泛型
        Type t = clazz.getGenericSuperclass();                          //（2）getGenericSuperclass(): 获取指定类超类泛型信息
        if (t instanceof ParameterizedType) {                           // 检查是否为泛型
            ParameterizedType pt = (ParameterizedType) t;               //（3）ParameterizedType: 表示泛型
            Type[] types = pt.getActualTypeArguments(); // 可能有多个泛型类型 //（4）.getActualTypeArguments():获取参数类型的实际参数
            Type firstType = types[0]; // 取第一个泛型类型
            Class<?> typeClass = (Class<?>) firstType;
            System.out.println(typeClass); // Integer
        }
        Pair<Integer> pair=new Pair<>(1,10);
        Pair<?> pair1=pair;               //pair<?> 是所有pair<T>的超类，可以安全转型
        System.out.println(run(pair));
        set(pair,10);
        System.out.println(run(pair));
    }

    static<T> T[] asArray(T... objs){       //... : 可变参数，可以接收任意数量相应参数。   //T... 实际是一个T[]
        return objs;
    }

    static int run (Pair<? extends Number> p){                //? extend Number: 接收所以泛型是Number及其子类的Pair类型 ·
        Number n1= p.getFirst();
        Number n2= p.getLast();
        return n1.intValue()+(int)n2;
    }
    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
 //       p.setFirst(new Integer(first.intValue() + 100));       //报错。因为p符合Pair<? extends Number>，传入add，但p自身的setFirst等方法不满足Pair<? extends Number>要求
   //     p.setLast(new Integer(last.intValue() + 100));        //p本身泛型类型仍是<Integer>
                                                                //方法参数签名setFirst(? extends Number)无法传递任何Number的子类型给setFirst(? extends Number)
        return p.getFirst().intValue() + p.getFirst().intValue();
    }
    static void set (Pair<? super Integer> p, Integer integer){     //?super Integer : 能接受Integer及其父类
        p.setFirst(integer);                                        //使用<? super Integer>通配符作为方法参数，表示方法内部代码对于参数只能写，不能读。（object 可读）
        p.setLast(integer);
        //Integer first = p.getFirst();  //super:无法获取Integer引用

    }/*使用<? super Integer>通配符表示：
允许调用set(? super Integer)方法传入Integer的引用；
不允许调用get()方法获得Integer的引用。*/
    /*
    * <? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）；
<? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）。
一个是允许读不允许写，另一个是允许写不允许读。
    * */
}
class Pair<T extends Number>  {                     //限制只能是number或number子类
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public void setFirst(T first){
        this.first=first;
    }
    public void setLast(T last){
        this.last=last;
    }
}

class IntPair extends Pair<Integer> {
    public IntPair(Integer first, Integer last) {
        super(first, last);
    }
}

class Collections {
    // 把src的每个元素复制到dest中:
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {        //限制只能把src List复制到dest List上，反之报错。
        for (int i=0; i<src.size(); i++) {
            T t = src.get(i);
            dest.add(t);
        }
    }
}/*
它的作用是把一个List的每个元素依次添加到另一个List中。它的第一个参数是List<? super T>，表示目标List，第二个参数List<? extends T>，表示要复制的List。
我们可以简单地用for循环实现复制。
在for循环中，我们可以看到，对于类型<? extends T>的变量src，我们可以安全地获取类型T的引用，而对于类型<? super T>的变量dest，我们可以安全地传入T的引用。
这个copy()方法的定义就完美地展示了extends和super的意图：
copy()方法内部不会读取dest，因为不能调用dest.get()来获取T的引用；
copy()方法内部也不会修改src，因为不能调用src.add(T)。
*/


/*
*                     ┌────┐
                      │Type│
                      └────┘
                         ▲
                         │
   ┌────────────┬────────┴─────────┬───────────────┐
   │            │                  │               │
┌─────┐┌─────────────────┐┌────────────────┐┌────────────┐
│Class││ParameterizedType││GenericArrayType││WildcardType│
*
* 使用类似<? extends Number>通配符作为方法参数时表示：
方法内部可以调用获取Number引用的方法，例如：Number n = obj.getFirst();；
方法内部无法调用传入Number引用的方法（null除外），例如：obj.setFirst(Number n);。
即一句话总结：使用extends通配符表示可以读，不能写。
使用类似<T extends Number>定义泛型类时表示：
泛型类型限定为Number以及Number的子类。
*
* 小结
* 部分反射API是泛型，例如：Class<T>，Constructor<T>；
可以声明带泛型的数组，但不能直接创建带泛型的数组，必须强制转型；
可以通过Array.newInstance(Class<T>, int)创建T[]数组，需要强制转型；
同时使用泛型和可变参数时需要特别小心。
* */