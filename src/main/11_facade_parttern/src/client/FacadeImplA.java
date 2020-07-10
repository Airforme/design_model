package client;

import system.SystemA;

public class FacadeImplA extends Facade{

    private SystemA systemA;

    public FacadeImplA(){
        systemA = new SystemA();
    }

    @Override
    public void method() {
        systemA.method_A();
    }
}
