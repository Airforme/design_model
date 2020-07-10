package client;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Client11 {

    /**
     * 优点:
     * 1.它对客户端屏蔽了子系统组件，减少了客户端所需处理的对象数目，并使得子系统使用起
     * 来更加容易。
     * 2.它实现了子系统与客户端之间的松耦合关系，这使得子系统的变化不会影响到调用它的客
     * 户端，只需要调整外观类即可。
     * 3.一个子系统的修改对其他子系统没有任何影响，而且子系统内部变化也不会影响到外观对
     * 象。
     *
     * 缺点:
     * 1.不能很好地限制客户端直接使用子系统类，如果对客户端访问子系统类做太多的限制则减
     * 少了可变性和灵活性。
     * 2.如果设计不当，增加新的子系统可能需要修改外观类的源代码，违背了开闭原则。
     *
     * 适用场景:
     * 1.当要为访问一系列复杂的子系统提供一个简单入口时可以使用外观模式。
     * 2.客户端程序与多个子系统之间存在很大的依赖性。
     * @param args
     */
    public static void main(String[] args) {
        Facade facade = (Facade)getBean();
        facade.method();
    }

    public static Object getBean(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("./src/main/11_facade_parttern/sources/config.xml"));
            NodeList n1 = doc.getElementsByTagName("type");
            Node classNode = n1.item(0).getFirstChild();
            String cName = classNode.getNodeValue().trim();
            Class <?> c = Class.forName(cName);
            Object o = c.newInstance();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
