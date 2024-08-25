
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //实现List
        List<String> ls1=new ArrayList<>();           //ArrayList :数组
        List<Integer> ls2=new LinkedList<>();           //LinkedList：链表
        List<Integer> list = List.of(1, 2, 5);         //只可读

        ls1.add("添加一个元素到末尾");
        ls1.add(0,"添加一个元素到索引0");
        ls1.add("第三个元素");

        System.out.println("contains(”第三个元素“):"+ls1.contains("第三个元素"));   //contains（）：判断是否具有某个指定元素
        System.out.println("index(”第三个元素“)"+ls1.indexOf("第三个元素"));        // index（）：获取某元素具体索引，没有则返回-1；

        for(String str:ls1){
            System.out.println(str);
        }
        //ls1.remove(1);
        //ls1.remove("添加一个元素到索引0");
        System.out.println();
        System.out.println("删除元素：添加一个元素到末尾："+"删除索引1上的元素：");
        for(Iterator<String> Ite = ls1.iterator();Ite.hasNext();){          //hasNext():判断是否有下一个元素
            String s=Ite.next();                                           //next():返回下一个元素
            System.out.println(s);
        }
        for (String s:ls1) {           //for each循环，本质也是使用帮助我们使用Iterator便利
            System.out.println(s);
        }
        //List和Array转换
        Object[] arr=ls1.toArray();            //.toArray() :list转Array
        String[] arr1=ls1.toArray(new String[ls1.size()]);   //传入一个类型相同的Array,List自动把元素复制到Array中
        //String[] arr2=ls1.toArray(String[]::new);          //版本问题Java8才能用
        for (Object s:arr) {
            System.out.println(s);
        }
        //练习
        // 构造从start到end的序列：
/*
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 随机删除List中的一个元素:有序
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
*/

        //无序：
        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list1 = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 洗牌算法shuffle可以随机交换List中的元素位置:
        Collections.shuffle(list);
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");

    }



    //有序
/*    static int findMissingNumber(int start, int end, List<Integer> list) {
        for (int s:list) {
            if(start++!=s){
                return --s;
            }
        }
        return 0;
    }*/
    //无序：
    static int findMissingNumber(int start, int end, List<Integer> list) {

        int b=0;
        List<Integer> ls=new ArrayList<>();
        for (int i = start; i <=end ; i++) {          //自己搞一个完成的数组
            ls.add(i);
        }
        for(int a:list){
            for(;;){
                if(a==ls.get(b++)){                  //一一剔除出现过的数，最终得到结果
                    ls.remove(--b);
                    break;
                }
            }b=0;
        }return ls.get(0);
    }
}

/*
* 在末尾添加一个元素：boolean add(E e)
在指定索引添加一个元素：boolean add(int index, E e)
删除指定索引的元素：E remove(int index)
删除某个元素：boolean remove(Object e)
获取指定索引的元素：E get(int index)
获取链表大小（包含元素的个数）：int size()
* */
/*
            ArrayList	LinkedList
获取指定元素	速度很快	需要从头开始查找元素
添加元素到末尾	速度很快	速度很快
在指定位置添加/删除	需要移动元素	不需要移动元素
内存占用  	少	        较大

洗牌算法shuffle ：可以随机交换List中的元素位置:
* */