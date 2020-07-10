package approver;

import approver.role.Congress;
import approver.role.Director;
import approver.role.President;
import approver.role.VicePresident;

public class Client {

    /**
     * 职责链模式:
     *
     * 优点:
     * 1.职责链模式使得一个对象无须知道是其他哪一个对象处理其请求，对象仅需知道该请求会
     * 被处理即可，接收者和发送者都没有对方的明确信息，且链中的对象不需要知道链的结构，
     * 由客户端负责链的创建，降低了系统的耦合度。
     * 2.请求处理对象仅需维持一个指向其后继者的引用，而不需要维持它对所有的候选处理者的
     * 引用，可简化对象的相互连接。
     * 3.在给对象分派职责时，职责链可以给我们更多的灵活性，可以通过在运行时对该链进行动
     * 态的增加或修改来增加或改变处理一个请求的职责。
     * 4.在系统中增加一个新的具体请求处理者时无须修改原有系统的代码，只需要在客户端重新
     * 建链即可，从这一点来看是符合“开闭原则”的。
     *  缺点:
     *  1.由于一个请求没有明确的接收者，那么就不能保证它一定会被处理，该请求可能一直到链
     * 的末端都得不到处理；一个请求也可能因职责链没有被正确配置而得不到处理。
     * 2.对于比较长的职责链，请求的处理可能涉及到多个处理对象，系统性能将受到一定影响，
     * 而且在进行代码调试时不太方便。
     * 3.如果建链不当，可能会造成循环调用，将导致系统陷入死循环。
     *
     * 适用场景:
     * 1.有多个对象可以处理同一个请求，具体哪个对象处理该请求待运行时刻再确定，客户端只
     * 需将请求提交到链上，而无须关心请求的处理对象是谁以及它是如何处理的。
     * 2.在不明确指定接收者的情况下，向多个对象中的一个提交一个请求。
     * 3.可动态指定一组对象处理请求，客户端可以动态创建职责链来处理请求，还可以改变链中
     * 处理者之间的先后次序。
     * @param args
     */
    public static void main(String[] args) {
        Approver director, vicePresident, president, meeting;
        director = new Director("布袋和尚");//主任
        vicePresident = new VicePresident("杨晓");
        president = new President("张无忌");
        meeting = new Congress("董事会");

        //创建责任链
        director.setSuccessor(vicePresident);
        vicePresident.setSuccessor(president);
        president.setSuccessor(meeting);
        //创建采购单
        PurchaseRequest pr1 = new PurchaseRequest(45000, 10001, "购买倚天剑");
        director.processRequest(pr1);
        PurchaseRequest pr2 = new PurchaseRequest(60000, 10002, "购买《葵花宝典》");
        director.processRequest(pr2);
        PurchaseRequest pr3 = new PurchaseRequest(160000, 10003, "购买《金刚经》");
        director.processRequest(pr3);
        PurchaseRequest pr4 = new PurchaseRequest(800000, 10004, "购买桃花岛");
        director.processRequest(pr4);

    }
}
