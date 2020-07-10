package command;

public class ModifyCommand extends Command {
    public ModifyCommand(String name) {
        super(name);
    }

    @Override
    public void execute() {
        this.configOperator.modify(this.args);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        this.configOperator.modify(args);
    }
}
