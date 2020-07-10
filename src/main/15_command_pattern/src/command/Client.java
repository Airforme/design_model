package command;

public class Client {

    /**
     * 命令模式:将请求发送者与接收者解耦，请求发送
     * 者通过命令对象来间接引用请求接收者，使得系统具有更好的灵活性和可扩展性。
     *
     * 优点:
     * 1.降低系统的耦合度。
     * 2.新的命令可以很容易地加入到系统中。
     * 3.可以比较容易地设计一个命令队列或宏命令（组合命令）。
     * 4.为请求的撤销(Undo)和恢复(Redo)操作提供了一种设计和实现方案。
     *
     * 缺点:
     * 使用命令模式可能会导致某些系统有过多的具体命令类。因为针对每一个对请求接收者的调
     * 用操作都需要设计一个具体命令类，因此在某些系统中可能需要提供大量的具体命令类，这
     * 将影响命令模式的使用。
     *
     * 适用场景:
     * 1.系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互。
     * 2.系统需要在不同的时间指定请求、将请求排队和执行请求。
     * 3.系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作。
     * 4.系统需要将一组操作组合在一起形成宏命令。
     *
     * @param args
     */
    public static void main(String[] args) {
        ConfigSettingWindow window = new ConfigSettingWindow();

        ConfigOperator operator = new ConfigOperator();//请求接收者

        Command command = new InsertCommand("增加");
        command.setConfigOperator(operator);
        window.setCommand(command);
        window.call("网站首页");

        command = new InsertCommand("增加");
        command.setConfigOperator(operator);
        window.setCommand(command);
        window.call("端口号");

        command = new InsertCommand("增加");
        command.setConfigOperator(operator);
        window.setCommand(command);
        window.call("端口号");

        command = new ModifyCommand("修改");
        command.setConfigOperator(operator);
        window.setCommand(command);
        window.call("端口号");

        command = new DeleteCommand("删除");
        command.setConfigOperator(operator);
        window.setCommand(command);
        window.call("端口号");
        System.out.println("-----------------------");

        window.save();

        System.out.println("----------------");
        window.recover();
    }
}
