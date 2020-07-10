package image.type;

import image.Image;
import image.Matrix;

public class JPGImage extends Image {
    @Override
    public void parseFile(String fileName) {
        System.out.println("解析JPG文件,或者矩阵对象");
        Matrix matrix = new Matrix();
        imp.doPaint(matrix);
        System.out.println(fileName+",格式为JPG.");
    }
}
