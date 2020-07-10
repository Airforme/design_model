public class Single_3 {

    private static Single_3 s3 = null;
    private Single_3(){
    }

    public synchronized static Single_3 getInstance(){
        if (s3 ==null){
            s3 = new Single_3();
        }
        return s3;
    }

    /**
     * 每次调用getInstance()时都需要进行线程锁定判断,导致系统性能大大降低
     * @param args
     */
    public static void main(String[] args) {
        Single_3 instance1 = Single_3.getInstance();
        Single_3 instance2 = Single_3.getInstance();
        System.out.println(instance1==instance2);
    }
}
