import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Word implements Document{
    private String title;
    private String owner;

    public Word() {
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

    public Word(String title, String owner) {
        this.title = title;
        this.owner = owner;
    }

    @Override
    public Word clone() {
        Word clone = null;
        try {
            clone = (Word)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            System.err.println("不支持复制");
        }
        return clone;
    }

    @Override
    public Word deepClone() {
        try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bao);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Word excel = (Word) ois.readObject();
            return excel;
        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("深度克隆失败");
            return null;
        }
    }

    @Override
    public void display() {
        System.out.println("Word文档");
    }
}
