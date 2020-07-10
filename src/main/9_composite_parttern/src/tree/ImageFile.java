package tree;

public class ImageFile extends AbstractFile {

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVrius() {
        System.out.println("对图片" + name + "文件进行杀毒");
    }
}
