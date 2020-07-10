package command;

import java.util.ArrayList;
import java.util.List;

public class ConfigSettingWindow {
    //存储每一次操作时的命令对象
    private List <Command> commands = new ArrayList <>();
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call(String args) {
        command.execute(args);
        commands.add(command);
    }

    public void save() {
        FileUtil.wirteCommands(commands);
        commands.clear();
    }

    public void recover(){
        ArrayList arrayList = FileUtil.readCommands();
        for (Object object: arrayList){
            Command c = (Command) object;
            c.execute();
        }
    }
}
