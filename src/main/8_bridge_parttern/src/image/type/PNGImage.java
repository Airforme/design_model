package image.type;

import image.Image;
import image.Matrix;

public class PNGImage extends Image {
    @Override
    public void parseFile(String fileName) {
        System.out.println("解析PNG文件,或者矩阵对象");
        Matrix matrix = new Matrix();
        imp.doPaint(matrix);
        System.out.println(fileName+",格式为PNG.");
    }
}
