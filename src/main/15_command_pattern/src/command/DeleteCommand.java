package command;

public class DeleteCommand extends Command{

    public DeleteCommand(String name) {
        super(name);
    }

    @Override
    public void execute() {
    this.configOperator.delete(this.args);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        this.configOperator.delete(args);
    }
}
