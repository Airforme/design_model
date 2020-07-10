package parttern_02;

import common.Animal;
import common.Cat;
import common.Dog;
import common.Pig;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * 简单工厂模式
 */
public class AnimalFactory {

    public static Animal getAnimal(String type){
        switch (type) {
            case "cat":
                return new Cat("喵喵喵");
                //break;
            case "dog":
                return new Dog("汪汪汪");
                //break;
            case "pig":
                return new Pig("哼哼哼");
                //break;
            default:
                return null;
        }
    }

    public static String getAnimalType() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("./src/main/1_simple_factory_parttern/sources/config.xml"));
            NodeList n1 = doc.getElementsByTagName("type");
            Node classNode = n1.item(0).getFirstChild();
            String type = classNode.getNodeValue().trim();
            return type;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 优点:
     * 1.工厂类包含必要的判断逻辑，可以决定在什么时候创建哪一个产品类的实例，客户端可以
     * 免除直接创建产品对象的职责，而仅仅“消费”产品，简单工厂模式实现了对象创建和使用的分
     * 离。
     * 2.客户端无须知道所创建的具体产品类的类名，只需要知道具体产品类所对应的参数即可
     * 3.通过引入配置文件，可以在不修改任何客户端代码的情况下更换和增加新的具体产品类，
     * 在一定程度上提高了系统的灵活性。
     *
     * 缺点:
     * 1.由于工厂类集中了所有产品的创建逻辑，职责过重，一旦不能正常工作，整个系统都要受
     * 到影响。
     * 2.使用简单工厂模式势必会增加系统中类的个数（引入了新的工厂类），增加了系统的复杂
     * 度和理解难度。
     * 3.系统扩展困难，一旦添加新产品就不得不修改工厂逻辑，在产品类型较多时，有可能造成
     * 工厂逻辑过于复杂，不利于系统的扩展和维护。
     * 4.简单工厂模式由于使用了静态工厂方法，造成工厂角色无法形成基于继承的等级结构。
     *
     * 适用场景:
     * 1.工厂类负责创建的对象比较少，由于创建的对象较少，不会造成工厂方法中的业务逻辑太
     * 过复杂。
     * 2.客户端只知道传入工厂类的参数，对于如何创建对象并不关心。
     * @param args
     */

    public static void main(String[] args) {
        String type = getAnimalType();
        Animal animal = AnimalFactory.getAnimal(type);
        animal.call();
    }
}
