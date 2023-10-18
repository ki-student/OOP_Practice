import java.util.Scanner;
public class Practice06_2 {
    static void printWords(String[] words, char[] chars){
        for (String word : words){
            boolean contain = false;
            for (char c : chars) {
                if (word.contains(String.valueOf(c))) {
                    contain = true;
                    break;
                }
            }
            if (contain) {
                System.out.println(word);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        System.out.print("press 5 letters : ");
        String letter = sc.nextLine();

        char[] inputChars = letter.toCharArray();
        String s = "i am    a person";
        String[] s1 = s.split(" ");

        printWords(s1, inputChars);
    }
}
