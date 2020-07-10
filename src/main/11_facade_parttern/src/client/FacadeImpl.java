package client;

import system.SystemA;
import system.SystemB;

public class FacadeImpl extends Facade {

    private SystemA systemA;
    private SystemB systemB;
    public FacadeImpl(){
        this.systemA=new SystemA();
        this.systemB = new SystemB();
    }

    @Override
    public void method() {
        systemA.method_A();
        systemB.method_B();
    }
}
