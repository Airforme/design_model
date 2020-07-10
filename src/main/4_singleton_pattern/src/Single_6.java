public class Single_6 {

    private Single_6(){
    }

    private static class HolderClass{
        private final static Single_6 instance = new Single_6();
    }
    public static Single_6 getInstance(){
        return HolderClass.instance;
    }

    /**
     * 既可以实现延迟加载，又可以保证线程安全，不影响系统性能，不失为 一种最好的Java语言单例模式实现方式
     *
     * 优点:
     * 1.单例模式提供了对唯一实例的受控访问
     * 2.由于在系统内存中只存在一个对象，因此可以节约系统资源，对于一些需要频繁创建和销
     * 毁的对象单例模式无疑可以提高系统的性能。
     * 3.允许可变数目的实例。基于单例模式我们可以进行扩展，使用与单例控制相似的方法来获
     * 得指定个数的对象实例，既节省系统资源，又解决了单例单例对象共享过多有损性能的问
     * 题。
     *
     * 缺点:
     *  1.由于单例模式中没有抽象层，因此单例类的扩展有很大的困难。
     *  2.单例类的职责过重，在一定程度上违背了“单一职责原则”。
     *  3.现在很多面向对象语言(如Java、C#)的运行环境都提供了自动垃圾回收的技术，因此，如
     * 果实例化的共享对象长时间不被利用，系统会认为它是垃圾，会自动销毁并回收资源，下次
     * 利用时又将重新实例化，这将导致共享的单例对象状态的丢失。
     *
     * 适用场景:
     * 1.系统只需要一个实例对象
     * 2.客户调用类的单个实例只允许使用一个公共访问点，除了该公共访问点，不能通过其他途
     * 径访问该实例。
     * @param args
     */
    public static void main(String[] args) {
        Single_6 instance1 = Single_6.getInstance();
        Single_6 instance2 = Single_6.getInstance();
        System.out.println(instance1==instance2);
    }
}
