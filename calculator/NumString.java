public class NumString {
    public static boolean isDigit(String num) {
        if (num == null) {
            return false;
        }
        try {
            int n = Integer.parseInt(num);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
