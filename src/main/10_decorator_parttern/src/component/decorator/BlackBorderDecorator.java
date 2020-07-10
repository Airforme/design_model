package component.decorator;

import component.ComonentDecorator;
import component.Component;

public class BlackBorderDecorator extends ComonentDecorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    public void display() {
        this.setBlackBorder();
        super.display();
    }

    public void setBlackBorder() {
        System.out.println("为构件添加黑色边框");
    }
}
