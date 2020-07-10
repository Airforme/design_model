package tree;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFolder implements File {
    protected List <File> fileList = new ArrayList <>();
    protected String name;

    abstract void add(File file);

    abstract void remove(File file);

    abstract File getChild(int i);
}
