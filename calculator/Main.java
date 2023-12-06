public class Main {
    public static void main(String[] args) {
        String[] exprs = { "123    +    45 - 4", " 123a + 45 - 4",
                           " 123 * 4 - 123 ", "123 + 50 * 4",
                           "123 + 50 % 5", "123 - 50 / 5" };

        Calculator calculator = new Calculator();
        for (String s : exprs) {
            calculator.setExpression(s);
            System.out.println("\nCalculating a new expression");
            if (calculator.getExprNoError()) {
                System.out.printf("%s = %d\n", calculator.getExpression(), calculator.calculate());
            }
            else {
                System.out.printf("%s 연산식 오류로 값을 계산못함\n", calculator.getExpression());
            }
        }
    }
}
