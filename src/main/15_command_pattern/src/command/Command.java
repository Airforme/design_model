package command;

import java.io.Serializable;

public abstract class Command implements Serializable {
    protected String name;
    protected String args;
    protected ConfigOperator configOperator;//维持接收对象的引用

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public ConfigOperator getConfigOperator() {
        return configOperator;
    }

    public void setConfigOperator(ConfigOperator configOperator) {
        this.configOperator = configOperator;
    }

    public abstract void execute();
    public abstract void execute(String args);


}
