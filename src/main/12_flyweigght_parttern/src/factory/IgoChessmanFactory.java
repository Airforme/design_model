package factory;

import entity.BlackIgoChessman;
import entity.IgoChessman;
import entity.WhiteIgoChessman;

import java.util.Hashtable;

public class IgoChessmanFactory {
    private static class HolderClass {
        private final static IgoChessmanFactory instance = new IgoChessmanFactory();
    }

    public static IgoChessmanFactory getInstance() {
        return HolderClass.instance;
    }

    private static Hashtable <String, IgoChessman> ht;

    private IgoChessmanFactory() {
        this.ht = new Hashtable();
        ht.put("b", new BlackIgoChessman());
        ht.put("w", new WhiteIgoChessman());
    }

    public IgoChessman getIgoChessman(String color){
        return ht.get(color);
    }
}
