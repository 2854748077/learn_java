import java.lang.reflect.*;
import java.util.Arrays;


public class Main{
    public static void main(String[] args)throws Exception {
        /*printClassInfo("".getClass());
        printClassInfo(Runnable.class);
        printClassInfo(java.time.Month.class);
        printClassInfo(String[].class);
        printClassInfo(int.class);*/

        student st1 =new student("三年级");                              //实例化
        st1.score=100;

        Class cla1=st1.getClass();                                            //三种获取对应Class实例方法   //getClass()
        Class cla2=student.class;                                   //类名.Class
        Class cla3=Class.forName("student");                        //Class.forName()

        Class cla4=cla1.getSuperclass();                                      //getSuperclass()：获取Class实例的父类
        System.out.println("获取student的父类的class："+cla4);
        Class s=Integer.class;
        Class[] is=s.getInterfaces();                                       //getInterfaces():获取实例Class实现的接口
        System.out.println("获取当前实例对象所有接口： "+Arrays.toString(is));
        System.out.println("getSuperclass获取接口的父接口："+java.io.Closeable.class.getSuperclass()); // null，对接口调用getSuperclass()总是返回null，获取接口的父接口要用getInterfaces()

        student st2=(student) cla1.newInstance();
        System.out.println("实例化成功:st2"+st2.getGrade());                    //通过反射创建新的实例 只能调用public无参数构造方法
        System.out.println("开始 "+ Arrays.toString(cla1.getConstructors())+"结束");               //getConstructors获取所有构造方法
        System.out.println("开始 "+cla1.getConstructor()+"结束");

        System.out.println(cla1.getClass()+"**"+cla1.getField("score"));      //获取public字段：getField();
        System.out.println(cla1.getDeclaredField("grade"));                  // 获取private字段：getDeclaredField()
        System.out.println(cla1.getField("name"));

         Field f =cla1.getDeclaredField("grade");        //获取字段
        f.setAccessible(true);                              //作用：不管这个字段是不是public，一律允许访问(访问private字段)
        Object value =f.get(st1);                             // f.get(st1)   获取st1对象实例，并返回实例对应的值
        System.out.println("通过反射获取到的值：grade="+value);                        //输出值
        f.set(st1,"五年级");                                   //Field.set():  通过反射修改原实例字段
        System.out.println("通过反射修改后的值：grade="+st1.getGrade());

        System.out.println(cla1.getMethod("getGrade"));                //getMethod(名字,参数):获取方法
        System.out.println(cla1.getMethod("setScore", int.class));

        Method method1=cla1.getMethod("setScore", int.class);            //通过实例获取Method对象
        System.out.println("原成绩："+st1.score);
        int a=(int)method1.invoke(st1,600);                           //Methods.invoke(对象实例，参数):通过反射调用实例方法
        System.out.println("调用方法修改后成绩"+a);

        Method method_test=cla1.getMethod("test", String.class);
        System.out.println("调用静态方法："+method_test.invoke(null,"修改后结果"));  //静态方法，目标实例永远是null



        int m=f.getModifiers();                     //获取修饰符
        System.out.println(Modifier.isFinal(m));    //false
        Modifier.isPublic(m); // false                 //通过修饰符判断是否符合要求//例子：Modifier.isPublic()
        Modifier.isProtected(m); // false
        Modifier.isPrivate(m); // true
        Modifier.isStatic(m); // false

        Object n = Integer.valueOf(123);
        boolean isDouble = n instanceof Double; // false
        boolean isInteger = n instanceof Integer; // true               //判断是否是某个实例

        //判断向上转型是否成立
        //isAssignableFrom():判断能否向上转型
        Integer.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Integer
        Number.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Number
        Object.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Object
        System.out.println("判断是否可以正常赋值:"+Integer.class.isAssignableFrom(Number.class)); // false，因为Number不能赋值给Integer

        //动态代理
        //当代理对象上的任何方法被调用时，InvocationHandler 的 invoke 方法就会被调用。
        InvocationHandler Handler =new InvocationHandler(){                       //InvocationHandler：负责接口的接口方法的创建和调用
            @Override
            public Object invoke(Object proxy,Method method,Object[] args){         //复写方法体
                System.out.println("方法名："+method.getName());
                if(method.getName()=="Hello"){
                    System.out.println("Good moring"+Arrays.toString(args));
                } if(method.getName()=="Hello2"){
                    System.out.println("Good moring");
                }
                return null;
            }
        };

        //Proxy.newProxyInstance():创建动态代理方法
        // getClassLoader:获取接口类（ClassLoader）加载器
        // new Class[]{hello.class}: 需要实现的接口数组，最少一个接口
        // handler：用处理接口方法实现InvocationHandler的实例
        //返回Object强制转型
        hello hello1=(hello) Proxy.newProxyInstance(hello.class.getClassLoader(),new Class[]{hello.class},Handler);  //
        hello1.Hello("实现动态代理");              //通过hello1代理调用接口方法
        hello1.Hello2();
    }

    /*static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());            //类名
        System.out.println("Simple name: " + cls.getSimpleName());      //获取简单名字
        if (cls.getPackage() != null) {                                 //判断包是否为空
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());           //检查是否为原始类型
    }*/



}

interface hello{
    public void Hello(String str);
    public void Hello2();
}
class person{
    public String name;
}
class student extends person{
    public int score;
    private String grade;
    public student(){}
    public student(String grate){
        this.grade=grate;
    }
    public int setScore(int score){
        this.score=score;
        return this.score;
    }
    public String getGrade(){
        return this.grade;
    }
    public static String test(String str1){
        return str1;
    }
}