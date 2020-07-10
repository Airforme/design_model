package image.imp;

import image.ImageImp;
import image.Matrix;

public class UnixImp implements ImageImp {
    @Override
    public void doPaint(Matrix m) {
        System.out.println("在Unix操作系统中显示图像");
    }
}
