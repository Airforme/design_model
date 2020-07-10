package command;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static void wirteCommands(List <Command> commands) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("config.log");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(commands);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("命令保存失败");
        }
    }

    public static ArrayList readCommands(){
        try {
            FileInputStream fileInputStream = new FileInputStream("config.log");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList arrayList = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("命令读取失败");
            return null;
        }
    }
}
