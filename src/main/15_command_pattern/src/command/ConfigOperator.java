package command;

import java.io.Serializable;

public class ConfigOperator implements Serializable {
    public void insert(String args) {
        System.out.println("增加新节点: "+args);
    }

    public void modify(String args){
        System.out.println("修改节点: "+args);
    }

    public void delete(String args){
        System.out.println("删除节点: "+args);
    }
}
