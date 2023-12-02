import java.awt.*;

abstract class Block {
    private Rectangle[] rectangles;

    Block(Point p) {
        rectangles = new Rectangle[4];
        initRectangles(p, rectangles);
    }

    public void translate(int x, int y) {
        for (Rectangle r : rectangles) {
            r.translate(x, y);
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Rectangle r : rectangles) {
            s.append(r.toString()).append("\n");
        }
        return s.toString();
    }

    public abstract void initRectangles(Point p, Rectangle[] rectangles);
}

class Block_1 extends Block {

    public Block_1(Point p) {
        super(p);
    }

    public Block_1(int x, int y) {
        this(new Point(x, y));
    }

    public void initRectangles(Point p, Rectangle[] rectangles) {
        int x = (int) p.getX();
        int y = (int) p.getY();
        rectangles[0] = new Rectangle(new Point(x, y));
        rectangles[1] = new Rectangle(new Point(x + Rectangle_1.WIDTH, y));
        rectangles[2] = new Rectangle(new Point(x, y + Rectangle_1.HEIGHT));
        rectangles[3] = new Rectangle(new Point(x + Rectangle_1.WIDTH, y + Rectangle_1.HEIGHT));
    }
}

class Block_2 extends Block {

    public Block_2(Point p) {
        super(p);
    }

    public Block_2(int x, int y) {
        this(new Point(x, y));
    }

    public void initRectangles(Point p, Rectangle[] rectangles) {
        int x = (int) p.getX();
        int y = (int) p.getY();
        rectangles[0] = new Rectangle(new Point(x, y + 0 * Rectangle_1.HEIGHT));
        rectangles[1] = new Rectangle(new Point(x, y + 1 * Rectangle_1.HEIGHT));
        rectangles[2] = new Rectangle(new Point(x, y + 2 * Rectangle_1.HEIGHT));
        rectangles[3] = new Rectangle(new Point(x, y + 3 * Rectangle_1.HEIGHT));
    }
}

class Rectangle_1 {
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    private Point upperLeft;
    private Point lowerRight;

    public Rectangle_1(Point uL) {
        upperLeft = uL;
        lowerRight = new Point((int) uL.getX() + WIDTH, (int) uL.getY() + HEIGHT);
    }

    public Rectangle_1(Point uL, Point lR) {
        upperLeft = uL;
        lowerRight = lR;
    }

    public void translate(int x, int y) {
        upperLeft.setLocation(upperLeft.getX() + x, upperLeft.getY() + y);
        lowerRight.setLocation(lowerRight.getX() + x, lowerRight.getY() + y);
    }

    public String toString() {
        return "UL: " + upperLeft.toString() + ", LR: " + lowerRight.toString();
    }
}

public class RectangleMain2 {
    public static void main(String[] args) {
        Block_1 b1 = new Block_1(10, 10);
        Block_2 b2 = new Block_2(20, 20);

        System.out.println("b1");
        System.out.println(b1);
        System.out.println("b2");
        System.out.println(b2);

        b1.translate(10, -10);
        System.out.println("b1 (translated)");
        System.out.println(b1);
    }
}