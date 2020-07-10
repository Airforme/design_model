package component;

import component.decorator.BlackBorderDecorator;
import component.decorator.ScrollBarDecorator;

public class Client10 {

    /**
     * 优点:
     * 1.对于扩展一个对象的功能，装饰模式比继承更加灵活性，不会导致类的个数急剧增加。
     * 2.可以通过一种动态的方式来扩展一个对象的功能，通过配置文件可以在运行时选择不同的
     * 具体装饰类，从而实现不同的行为。
     * 3.可以对一个对象进行多次装饰，通过使用不同的具体装饰类以及这些装饰类的排列组合，
     * 可以创造出很多不同行为的组合，得到功能更为强大的对象。
     * 4.具体构件类与具体装饰类可以独立变化，用户可以根据需要增加新的具体构件类和具体装
     * 饰类，原有类库代码无须改变，符合“开闭原则”。
     * 缺点:
     * 1.使用装饰模式进行系统设计时将产生很多小对象，这些对象的区别在于它们之间相互连接
     * 的方式有所不同，而不是它们的类或者属性值有所不同，大量小对象的产生势必会占用更多
     * 的系统资源，在一定程序上影响程序的性能。
     * 2.装饰模式提供了一种比继承更加灵活机动的解决方案，但同时也意味着比继承更加易于出
     * 错，排错也很困难，对于多次装饰的对象，调试时寻找错误可能需要逐级排查，较为繁琐。
     *
     * 适用场景:
     * 1.在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
     * 2.当不能采用继承的方式对系统进行扩展或者采用继承不利于系统扩展和维护时可以使用装
     * 饰模式。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Component c1=new Window();
        Component c2sb=new ScrollBarDecorator(c1);
        Component c3 = new BlackBorderDecorator(c2sb);
        c3.display();

        Component c1T=new TextBox();
        Component c2Tsb=new ScrollBarDecorator(c1T);
        Component c3T = new BlackBorderDecorator(c2Tsb);
        c3T.display();

    }
}
