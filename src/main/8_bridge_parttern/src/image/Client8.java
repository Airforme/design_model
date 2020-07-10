package image;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Client8 {

    /**
     * 适配器模式通常可以与桥接模式联合使用。适配器模式可以解决两个已有接
     * 口间不兼容问题，在这种情况下被适配的类往往是一个黑盒子，有时候我们不想也不能改变
     * 这个被适配的类，也不能控制其扩展。
     *
     * 优点:
     * 1.分离抽象接口及其实现部分。
     * 2.在很多情况下，桥接模式可以取代多层继承方案，多层继承方案违背了“单一职责原则”，
     * 复用性较差，且类的个数非常多，桥接模式是比多层继承方案更好的解决方法，它极大减少
     * 了子类的个数。
     * 3.桥接模式提高了系统的可扩展性，在两个变化维度中任意扩展一个维度，都不需要修改原
     * 有系统，符合“开闭原则”。
     *
     * 缺点:
     * 1.桥接模式的使用会增加系统的理解与设计难度，由于关联关系建立在抽象层，要求开发者
     * 一开始就针对抽象层进行设计与编程。
     * 2.桥接模式要求正确识别出系统中两个独立变化的维度，因此其使用范围具有一定的局限
     * 性，如何正确识别两个独立维度也需要一定的经验积累。
     *
     * 适用场景
     *
     * 1.如果一个系统需要在抽象化和具体化之间增加更多的灵活性，避免在两个层次之间建立静
     * 态的继承关系，通过桥接模式可以使它们在抽象层建立一个关联关系。
     * 2.“抽象部分”和“实现部分”可以以继承的方式独立扩展而互不影响，在程序运行时可以动态
     * 将一个抽象化子类的对象和一个实现化子类的对象进行组合，即系统需要对抽象化角色和实
     * 现化角色进行动态耦合。
     * 3.一个类存在两个（或多个）独立变化的维度，且这两个（或多个）维度都需要独立进行扩展。
     * 4.对于那些不希望使用继承或因为多层继承导致系统类的个数急剧增加的系统，桥接模式尤为适用。
     * @param args
     */
    public static void main(String[] args) {
        Image image = (Image)getBean("image");
        ImageImp os = (ImageImp)getBean("os");
        image.setImageImp(os);
        image.parseFile("小龙女");
    }

    public static Object getBean(String image) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("./src/main/8_bridge_parttern/sources/config.xml"));
            NodeList n1 = doc.getElementsByTagName("className");
            Node classNode;
            if (image.equals("image")) {
//获取第一个包含类名的节点，即扩充抽象类
                classNode = n1.item(0).getFirstChild();
            } else if (image.equals("os")) {
//获取第二个包含类名的节点，即具体实现类
                classNode = n1.item(1).getFirstChild();
            } else {
                return null;
            }
            String cName = classNode.getNodeValue();
//通过类名生成实例对象并将其返回
            Class c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
