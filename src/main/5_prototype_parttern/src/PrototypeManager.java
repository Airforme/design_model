import java.util.Hashtable;

public class PrototypeManager {

    private Hashtable hashtable = new Hashtable();

    private PrototypeManager() {
        hashtable.put("excel", new Excel());
        hashtable.put("word", new Word());
    }

    public void addExcel(String key, Excel excel) {
        hashtable.put(key, excel);
    }

    public void addWord(String key, Word word) {
        hashtable.put(key, word);
    }

    public Excel getExcelClone(String key) {
        return ((Excel) hashtable.get(key)).clone();
    }

    public Excel getExcelDeepClone(String key) {
        return ((Excel) hashtable.get(key)).deepClone();
    }

    public Word getWordClone(String key) {
        return ((Word) hashtable.get(key)).clone();
    }

    public Word getWordDeepClone(String key) {
        return ((Word) hashtable.get(key)).deepClone();
    }

    private static class HolderClass {
        private final static PrototypeManager instance = new PrototypeManager();
    }

    public static PrototypeManager getInstance() {
        return HolderClass.instance;
    }

    public static void main(String[] args) {
        PrototypeManager instance1 = PrototypeManager.getInstance();
        PrototypeManager instance2 = PrototypeManager.getInstance();
        System.out.println(instance1 == instance2);

        Excel excel1 = instance1.getExcelClone("excel");
        Excel excel2 = instance2.getExcelClone("excel");
        System.out.println(excel1 == excel2);
        Word word1 = instance1.getWordDeepClone("word");
        Word word2 = instance1.getWordDeepClone("word");
        System.out.println(word1 == word2);
    }
}
