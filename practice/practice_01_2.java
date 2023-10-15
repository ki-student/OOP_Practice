import java.util.Scanner;

public class practice_01_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double Earth = 5.9722 * Math.pow(10,24);
        double Moon = 7.342 * Math.pow(10,22);
        double r = 384400;
        double G = 6.67384 * Math.pow(10, -11);
        double F = G * ((Earth * Moon) / r);

        System.out.println("F : " + F);

    }
}
