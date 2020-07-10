import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Excel implements Document{
    private String title;
    private String owner;

    public Excel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Excel(String title, String owner) {
        this.title = title;
        this.owner = owner;
    }

    @Override
    public Excel clone() {
        Excel clone = null;
        try {
            clone = (Excel)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.err.println("不支持复制");
        }
        return clone;
    }

    @Override
    public Excel deepClone() {
        try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bao);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Excel excel = (Excel) ois.readObject();
            return excel;
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("深度克隆失败");
            return null;
        }
    }

    @Override
    public void display() {
        System.out.println("Excel文档");
    }
}
