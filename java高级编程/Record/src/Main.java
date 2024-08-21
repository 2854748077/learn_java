// 按两次 Shift 打开“随处搜索”对话框并输入 `show whitespaces`，
// 然后按 Enter 键。现在，您可以在代码中看到空格字符。
public class Main {
    public static void main(String[] args) {

    var p= point.of(10,30);
    System.out.println(p.x()+" "+p.y()+" "+p);

    }
}
record point(int x , int y){                     //自动生成构造方法

    public point {                                    //public Point {...} 被称为Compact Constructor，目的是让我们编写检查逻辑，
        if(x<0||y<0){
            throw new IllegalArgumentException();
        }
    }
    /*等价于： public Point(int x, int y) {
        // 这是我们编写的Compact Constructor:
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException();
        }
        // 这是编译器继续生成的赋值代码:
        this.x = x;
        this.y = y;
    }
    */
    public static point of(int x, int y){
        return new point(x,y);
    }
    public static point of(){
        return new point(0,0);
    }
}