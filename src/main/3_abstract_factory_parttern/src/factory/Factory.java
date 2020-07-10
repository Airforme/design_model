package factory;

import product.ProductA;
import product.ProductB;

public interface Factory {
    public abstract ProductA createAbstractProductA();
    public abstract ProductB createAbstractProductB();
}
