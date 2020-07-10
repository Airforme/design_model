package factory;

import product.ConcreteProductA2;
import product.ConcreteProductB2;
import product.ProductA;
import product.ProductB;

public class ConcreteFactory2 implements Factory {
    @Override
    public ProductA createAbstractProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createAbstractProductB() {
        return new ConcreteProductB2();
    }
}
