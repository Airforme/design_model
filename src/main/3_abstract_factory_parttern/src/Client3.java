import factory.ConcreteFactory1;
import factory.Factory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import product.ProductA;
import product.ProductB;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Client3 {

    /**
     * 抽象工厂
     * 优点:
     * 1.抽象工厂模式隔离了具体类的生成，使得客户并不需要知道什么被创建。
     * 2.当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产
     * 品族中的对象。
     * 3.增加新的产品族很方便，无须修改已有系统，符合“开闭原则”。
     *
     * 缺点:
     * 1.增加新的产品等级结构麻烦，需要对原有系统进行较大的修改，甚至需要修改抽象层代码，
     * 这显然会带来较大的不便，违背了“开闭原则”。
     *
     * 适用场景:
     * 1.一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有类型的工
     * 厂模式都是很重要的，用户无须关心对象的创建过程，将对象的创建和使用解耦。
     * 2.系统中有多于一个的产品族，而每次只使用其中某一产品族。
     * 3.属于同一个产品族的产品将在一起使用，这一约束必须在系统的设计中体现出来。
     * 4.产品等级结构稳定，设计完成之后，不会向系统中增加新的产品等级结构或者删除已有的
     * 产品等级结构。
     * @param args
     */
    public static void main(String[] args) {
        Factory f1= (Factory)getBean();
        ProductA a = f1.createAbstractProductA();
        ProductB b = f1.createAbstractProductB();
        a.display();
        b.display();
    }

    public static Object getBean(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("./src/main/3_abstract_factory_parttern/sources/config.xml"));
            NodeList n1 = doc.getElementsByTagName("type");
            Node classNode = n1.item(0).getFirstChild();
            String cName = classNode.getNodeValue().trim();
            Class <?> c = Class.forName("factory."+cName);
            Object o = c.newInstance();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
