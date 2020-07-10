import java.io.Serializable;

public interface Document extends Cloneable, Serializable {
    /**
     * 浅克隆
     * @return
     */
    Document clone();

    /**
     * 深克隆
     * @return
     */
    Document deepClone();
    void display();
}
