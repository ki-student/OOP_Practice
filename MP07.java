class Shape{
    public double getArea(){return 0.0;}
    public double getPerimeter(){return 0.0;}
    public String toString(){return "shape:";}
}

class Circle extends Shape{
    private Point01 center;
    private int radius;

    public Circle(Point01 p, int r){
        center = p;
        radius = r;
    }
    public Circle(int x, int y, int r){
        this(new Point01(x, y), r);
    }
    public double getArea(){return Math.PI * radius * radius;}
    public double getPerimeter(){return 2*Math.PI*radius;}
    @Override
    public String toString(){
        return String.format("Circle:\ncenter: %s\nradius: %d", center.toString(), radius);
    }
}

class Rectangle01 extends Shape{
    private Point01 p1;
    private Point01 p2;

    public Rectangle01(Point01 p1, Point01 p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    public Rectangle01(int x1, int y1, int x2, int y2){
        this(new Point01(x1, y1), new Point01(x2, y2));
    }
    public double getArea(){
        return Math.abs(p1.getX() - p2.getX()) * Math.abs(p1.getY() - p2.getY());
    }
    public double getPerimeter(){
        return 2 * (Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY()));
    }
    @Override
    public String toString(){
        return String.format("Rectangle:\np1: %s\np2: %s", p1.toString(), p2.toString());
    }
}

class Point01 {
    private int x;
    private int y;

    public Point01(){
        x = 0;
        y = 0;
    }
    public Point01(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public String toString(){return "("+x+", "+y+")";}
}
public class MP07 {
    private static final int NUM = 4;
    public static void main(String[] args) {
        Shape[] shapes = new Shape[NUM];
        shapes[0] = new Rectangle01(20, 30, 50, 50);
        shapes[1] = new Circle(30, 30, 20);
        shapes[2] = new Rectangle01(new Point01(20, 30),
                new Point01(50, 50));
        shapes[3] = new Circle(new Point01(30, 30), 20);
        for (int i = 0; i < NUM; i++) {
            System.out.println(shapes[i]);
            System.out.printf("면적: %.2f\n",
                    shapes[i].getArea());
            System.out.printf("둘레: %.2f\n",
                    shapes[i].getPerimeter());
        }
    }
}