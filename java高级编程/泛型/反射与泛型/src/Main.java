import java.util.Arrays;

class main {
    public static void main(String[] args) {
        String[] arr = asArray("one", "two", "three");
        System.out.println(Arrays.toString(arr));
        // ClassCastException:                                        //转型错误：当试图将一个对象强制转换为并非其实际类型（或超类型）的另一个类型
        String[] firstTwo = pickTwo("one", "two", "three");
        System.out.println(Arrays.toString(firstTwo));
    }

    //个人理解，泛型不能嵌套使用
    static <K> K[] pickTwo(K k1, K k2, K k3) {        //报错原因：由于擦拭法，编译器把 K 擦拭成Object，执行K方法里面的asArray方法不会再次擦拭，
        return asArray(k1, k2);                         //所以会直接返回Object类型，但T实际类型是String，所以出现转型报错。
    }

    static <T> T[] asArray(T... objs) {
        return objs;
    }
}