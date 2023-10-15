import java.util.Scanner;

public class practice_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("x1 : ");
        double x1 = sc.nextInt();
        System.out.print("y1 : ");
        double y1 = sc.nextInt();
        System.out.print("x2 : ");
        double x2 = sc.nextInt();
        double x3 = (x1 + x2) / 2;

        double Area = Math.sqrt(3)/4 * Math.pow((x2-x1),2);
        double y2 = Math.sqrt(3)/2 * (x2-x1);

        System.out.println("(x3, y2) : ("+x3+","+y2+")");
        System.out.println("Area : "+Area);
    }
}
