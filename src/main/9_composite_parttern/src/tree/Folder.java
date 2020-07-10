package tree;

public class Folder extends AbstractFolder {

    public Folder(String name){
        this.name = name;
    }

    @Override
    public void killVrius() {
        for (File f : fileList) {
            f.killVrius();
        }
    }
    @Override
    public void add(File file) {
        fileList.add(file);
    }
    @Override
    public void remove(File file) {
        fileList.remove(file);
    }
    @Override
    public File getChild(int i) {
        return fileList.get(i);
    }


}
