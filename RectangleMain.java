import java.awt.Point;

import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;

class Rectangle{
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    private Point upperLEFT;
    private Point lowerRight;

    public Rectangle(Point uL){
        upperLEFT = uL;
        lowerRight = new Point(upperLEFT.x + WIDTH, upperLEFT.y + HEIGHT);
    }
    public Rectangle(Point uL, Point lR){upperLEFT = uL; lowerRight = lR;}
    public void translate(int x, int y){
        upperLEFT.translate(x, y);
        lowerRight.translate(x, y);
    }
    public String toString(){
        return "[(" + upperLEFT.x + "," + upperLEFT.y + "),(" + lowerRight.x + "," + lowerRight.y + ")]";
    }
}

class Block1 {
    private Rectangle[] rectangles;

    public Block1(Point p) {
        rectangles = new Rectangle[4];
        rectangles[0] = new Rectangle(p);
        rectangles[1] = new Rectangle(new Point(p.x + WIDTH, p.y));
        rectangles[2] = new Rectangle(new Point(p.x, p.y + HEIGHT));
        rectangles[3] = new Rectangle(new Point(p.x + WIDTH, p.y + HEIGHT));
    }

    public Block1(int x, int y) {
        this(new Point(x, y));
    }

    public void translate(int x, int y) {
        for (Rectangle rect : rectangles) {
            rect.translate(x, y);
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rectangles.length; i++) {
            result.append("Rectangle ").append(i + 1).append(": ").append(rectangles[i].toString()).append("\n");
        }
        return result.toString();
    }
}

class Block2{
    private Rectangle[] rectangles;
    public Block2(Point p){
        rectangles = new Rectangle[4];
        rectangles[0] = new Rectangle(p);
        rectangles[1] = new Rectangle(new Point(p.x + WIDTH, p.y));
        rectangles[2] = new Rectangle(new Point(p.x, p.y + HEIGHT));
        rectangles[3] = new Rectangle(new Point(p.x + WIDTH, p.y + HEIGHT));
    }

    public Block2(int x, int y) {
        this(new Point(x, y));
    }

    public void translate(int x, int y) {
        for (Rectangle rect : rectangles) {
            rect.translate(x, y);
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rectangles.length; i++) {
            result.append("Rectangle ").append(i + 1).append(": ").append(rectangles[i].toString()).append("\n");
        }
        return result.toString();
    }
}

public class RectangleMain {
    public static void main(String[] args) {
        Block1 b = new Block1(10, 10);
        Rectangle r = new Rectangle(new Point(10, 10));
        Rectangle r2 = new Rectangle(new Point(20, 20),
                new Point(70, 70));
        System.out.println("r");
        System.out.println(r);
        System.out.println("r2");
        System.out.println(r2);
        System.out.println("b");
        System.out.println(b);
        b.translate(10, -10);
        System.out.println("b");
        System.out.println(b);
    }
}