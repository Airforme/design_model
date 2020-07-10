public class Single_2 {

    private static Single_2 s2 = null;
    private Single_2(){
    }

    public static Single_2 getInstance(){
        if (s2 ==null){
            s2 = new Single_2();
        }
        return s2;
    }

    /**
     * 在多线程下,可能会出现多个实例
     * @param args
     */
    public static void main(String[] args) {
        Single_2 instance1 = Single_2.getInstance();
        Single_2 instance2 = Single_2.getInstance();
        System.out.println(instance1==instance2);
    }
}
