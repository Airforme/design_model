package tree;

public class TextFile extends AbstractFile {

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVrius() {
        System.out.println("对Text" + name + "文件进行杀毒");
    }
}
