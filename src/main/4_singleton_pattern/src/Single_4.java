public class Single_4 {

    private static Single_4 s4 = null;
    private Single_4(){
    }

    public static Single_4 getInstance(){
        if (s4 ==null){
            synchronized (Single_2.class) {
                s4 = new Single_4();
            }
        }
        return s4;
    }

    /**
     * 在某一瞬间线程A和线程B都在调用getInstance()方法，此时instance对象为null值，均能 通过instance == null的判断
     * @param args
     */
    public static void main(String[] args) {
        Single_4 instance1 = Single_4.getInstance();
        Single_4 instance2 = Single_4.getInstance();
        System.out.println(instance1==instance2);
    }
}
