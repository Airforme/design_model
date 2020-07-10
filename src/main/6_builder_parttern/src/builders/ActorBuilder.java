package builders;

import actor.Actor;

public abstract class ActorBuilder {
    public Actor actor = new Actor();

    public abstract void buildType();
    public abstract void buildSex();
    public abstract void buildFace();
    public abstract void buildCostume();
    public abstract void buildHairstyle();
    public Actor createActor(){
        return actor;
    }

    public Actor construct(){
        this.buildType();
        this.buildSex();
        this.buildFace();
        this.buildCostume();
        this.buildHairstyle();
        return actor;
    }

    /**
     * 优点:
     * 1.在建造者模式中，客户端不必知道产品内部组成的细节，将产品本身与产品的创建过程解
     * 耦，使得相同的创建过程可以创建不同的产品对象。
     * 2.每一个具体建造者都相对独立，而与其他的具体建造者无关，因此可以很方便地替换具体
     * 建造者或增加新的具体建造者，用户使用不同的具体建造者即可得到不同的产品对象。
     * 3.可以更加精细地控制产品的创建过程。
     *
     * 缺点:
     * 1.建造者模式所创建的产品一般具有较多的共同点，其组成部分相似，如果产品之间的差异
     * 性很大，例如很多组成部分都不相同，不适合使用建造者模式，因此其使用范围受到一定的
     * 限制。
     * 2.如果产品的内部变化复杂，可能会导致需要定义很多具体建造者类来实现这种变化，导致
     * 系统变得很庞大，增加系统的理解难度和运行成本。
     *
     * 适用场景:
     * 1.需要生成的产品对象有复杂的内部结构，这些产品对象通常包含多个成员属性。
     * 2.需要生成的产品对象的属性相互依赖，需要指定其生成顺序。
     * 3.对象的创建过程独立于创建该对象的类。
     * 4.隔离复杂对象的创建和使用，并使得相同的创建过程可以创建不同的产品。
     *
     * @param args
     */
    public static void main(String[] args) {
        ActorBuilder actorBuilder = new DevilBuilder();
        Actor devil = actorBuilder.construct();
        System.out.println(devil);
    }
}
