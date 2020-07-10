public class Single_5 {

    private volatile static Single_5 s5 = null;
    private Single_5(){
    }

    public static Single_5 getInstance(){
        if (s5 ==null){
            synchronized (Single_2.class) {
                if (s5 ==null){
                    s5 = new Single_5();
                }
            }
        }
        return s5;
    }

    /**
     * 被volatile修饰的成员变量可以确保多个线程都能够正确处理,
     * volatile关键字会屏蔽Java 虚拟机所做的一些代码优化，可能会导致系统运行效率降低
     * @param args
     */
    public static void main(String[] args) {
        Single_5 instance1 = Single_5.getInstance();
        Single_5 instance2 = Single_5.getInstance();
        System.out.println(instance1==instance2);
    }
}
