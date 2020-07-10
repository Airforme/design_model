package image.imp;

import image.ImageImp;
import image.Matrix;

public class WindowsImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        System.out.println("在Windows系统中显示图像");
    }
}
