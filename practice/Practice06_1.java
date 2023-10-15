import java.util.Arrays;
import java.util.Scanner;
public class Practice06_1 {
    static void printNumOccurrences(String s, char[] chars) {
        for (char c : chars) { // for each문을 통해 chars에 저장된 letters 배열울 c를 통해 순회하여 비교하도록 한다.
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    count++;
                }
            }
            System.out.println(c + ": " + count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("press 5 letters : ");
        String letter = sc.nextLine();

        if (letter.length() < 5) {
            System.out.print("error(press 5 letters)");
        } else {
            char[] inputChars = letter.toCharArray();
            String string = "In blandit lacus ac sapien dictum, elementum fringilla sem varius. Vestibulum consectetur metus at felis porttitor, a rhoncus neque consectetur. Integer vehicula felis non metus eleifend, in blandit risus ullamcorper. Phasellus mauris nisi, facilisis et quam placerat, congue venenatis diam. Praesent in erat odio. Phasellus sit amet efficitur sem. Ut quis mi venenatis, feugiat justo eu, rhoncus velit. Suspendisse iaculis tempus sapien. Integer mauris neque, posuere sed mi at, aliquet facilisis nibh. Cras vel blandit lorem. Aliquam suscipit, nisl id condimentum condimentum, purus magna maximus sem, vitae vehicula diam nisi ac enim.";

            printNumOccurrences(string, inputChars);
        }
    }
}