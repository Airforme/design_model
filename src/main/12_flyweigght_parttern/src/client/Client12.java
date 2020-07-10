package client;

import entity.Coordinates;
import entity.IgoChessman;
import factory.IgoChessmanFactory;

public class Client12 {

    public static void main(String[] args) {

        IgoChessmanFactory factory = IgoChessmanFactory.getInstance();
        IgoChessman b1 = factory.getIgoChessman("b");
        IgoChessman b2 = factory.getIgoChessman("b");
        IgoChessman b3 = factory.getIgoChessman("b");
        System.out.println("判断两颗黑子是否相同; " + (b1 == b2));
        IgoChessman w1 = factory.getIgoChessman("w");
        IgoChessman w2 = factory.getIgoChessman("w");
        IgoChessman w3 = factory.getIgoChessman("w");
        System.out.println("判断两颗白子是否相同; " + (w1 == w2));
        //b1.display();
        //b2.display();
        //b3.display();
        //w1.display();
        //w2.display();
        //w3.display();
        new Coordinates(1,2,b1).display();
        new Coordinates(1,3,b1).display();
        new Coordinates(1,4,b1).display();
        new Coordinates(4,2,b1).display();
        new Coordinates(3,2,b1).display();
        new Coordinates(1,2,b1).display();



    }
}
