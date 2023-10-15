import java.util.Scanner;

public class practice_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Humid : ");
        double Humid = sc.nextDouble();
        System.out.print("Temp : ");
        double Temp = sc.nextDouble();

        double DP = Math.log(Humid / 100) + 17.62 * Temp / (243.12 + Temp);
        int DewPoint = (int)(((243.12 * DP) / (17.62 - DP)) * 10);
        double result = DewPoint / 10.0;

        System.out.println("DewPoint : " + result);
    }
}
