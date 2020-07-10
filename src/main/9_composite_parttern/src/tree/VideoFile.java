package tree;

public class VideoFile extends AbstractFile {

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVrius() {
        System.out.println("对video" + name + "文件进行杀毒");
    }
}
