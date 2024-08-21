public class student<T> {
    private T grate;
    public T getGrate(T grate){
        this.grate=grate;
        System.out.println(this.grate);
        return this.grate;
    }
    public static <k> void setGrate(k grade){
        System.out.println("调用泛型类静态方法"+grade);
    }

}