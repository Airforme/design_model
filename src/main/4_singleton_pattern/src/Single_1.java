public class Single_1 {
    private static final Single_1 s1 = new Single_1();

    private Single_1(){}

    public static Single_1 getInstance(){
        return s1;
    }

    /**
     * 加载类时就创建了对象,占用内存
     * @param args
     */
    public static void main(String[] args) {
        Single_1 instance1 = Single_1.getInstance();
        Single_1 instance2 = Single_1.getInstance();
        System.out.println(instance1==instance2);
    }
}
