package factory;

import product.ConcreteProductA1;
import product.ConcreteProductB1;
import product.ProductA;
import product.ProductB;

public class ConcreteFactory1 implements Factory {

    @Override
    public ProductA createAbstractProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createAbstractProductB() {
        return new ConcreteProductB1();
    }
}
