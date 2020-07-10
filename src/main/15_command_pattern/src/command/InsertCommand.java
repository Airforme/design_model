package command;

public class InsertCommand extends Command {

    public InsertCommand(String name) {
        super(name);
    }

    @Override
    public void execute() {
        configOperator.insert(this.args);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        configOperator.insert(this.args);
    }
}
