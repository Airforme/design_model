package entity;

public class Coordinates {

    private int x;
    private int y;
    private IgoChessman igoChessman;


    public Coordinates(int x, int y, IgoChessman igoChessman) {
        this.x = x;
        this.y = y;
        this.igoChessman = igoChessman;
    }

    public void display() {
        igoChessman.display();
        System.out.println("棋子位置:" + x + "," + y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
