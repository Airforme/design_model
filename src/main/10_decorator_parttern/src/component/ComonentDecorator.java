package component;

public class ComonentDecorator extends Component {
    private Component component;//维持对抽象构件类型对象的引用

    public ComonentDecorator(Component component) {//注入抽象构件
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}
