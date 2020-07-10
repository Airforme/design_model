import javafx.scene.transform.Rotate;
import system.SystemA;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class File8 {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("os.name"));
        Path path = Paths.get("E:\\WORK\\需求\\sf");
        String s = path.toString();
        System.out.println(s);
        Path fileName = path.getFileName();
        System.out.println(fileName);
        boolean absolute = path.isAbsolute();
        System.out.println(absolute);
        Path path1 = path.toAbsolutePath();
        System.out.println(path1.toString());
        //File file = new File(path);

        FileSystem aDefault = FileSystems.getDefault();
        PathMatcher pathMatcher = aDefault.getPathMatcher("glob:**/*.docx");
        Files.walk(path, FileVisitOption.FOLLOW_LINKS)
                //.map(p->p.getFileName())
                .filter(m -> pathMatcher.matches(m))
                .forEach(System.out::println);
        System.out.println("*************************");
        PathMatcher pathMatcher1 = aDefault.getPathMatcher("glob:*.docx");
        Files.walk(path, FileVisitOption.FOLLOW_LINKS)
                .map(Path::getFileName)
                .filter(pathMatcher1::matches)
                .forEach(System.out::println);
        System.out.println("**************************");
        Path textPath = Paths.get("src/main/17_iterator_pattern/source/test.txt");
        System.out.println(textPath.toAbsolutePath());
        //一次性读取所有文件
        Files.readAllLines(textPath).stream()
                .forEach(System.out::println);

        System.out.println("***********************************");
        Files.lines(textPath)//流式读取文件
                .filter(a -> a.contains("a"))
                .forEach(System.out::println);
        System.out.println("**************************读的同时写入");
        Stream <String> lines = Files.lines(textPath);
        PrintWriter printWriter = new PrintWriter("F:/learn/rust/design_model/src/main/17_iterator_pattern/source/testout.txt");
        lines.map(l -> {
            System.out.println(l + "**");
            return l + "*";
        })
                .filter(l -> l.contains("a"))
                .forEach(printWriter::println);

        printWriter.flush();

        //Stream.generate();
    }
}
