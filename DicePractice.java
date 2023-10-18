import  java.util.Scanner;
class Dice {
    private int[] rolls;

    Dice(int n) {
        rolls = new int[n];
    }

    public void roll() {
        for (int i = 0; i < rolls.length; i++) {
            int roll = (int) Math.floor(Math.random() * 6) + 1;
            rolls[i] = roll;
        }
    }// int rollResult = random.nextInt(6) + 1; // 1부터 6까지의 난수 생성
    // rolls[i] = rollResult;

    public int[] getRolls() {
        return rolls;
    }
}

class DiceProbability {
    private Dice dice;
    private int n;
    private int[] counts;
    private double[] probabilities;

    DiceProbability(int n) {
        this.n = n;
        dice = new Dice(n);
        counts = new int[6];
        probabilities = new double[6];
    }

    public void calcProbability() {
        dice.roll();
        int[] rolls = dice.getRolls();

        for (int i = 0; i < rolls.length; i++) {
            counts[rolls[i] - 1]++;
        }

        for (int i = 0; i < 6; i++) {
            probabilities[i] = (double) counts[i] / n;
        }
    }

    public void printProbability() {
        System.out.println("총 횟수: " + n);
        for (int i = 0; i < 6; i++) {
            int number = i + 1;
            double ratio = probabilities[i];
            System.out.printf("주사위 %d: %d 비율: %.3f\n", number, counts[i], ratio);
        }
    }
}

public class DicePractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dice try time: ");
        int n = sc.nextInt();

        DiceProbability dice = new DiceProbability(n);
        dice.calcProbability();
        dice.printProbability();
    }
}