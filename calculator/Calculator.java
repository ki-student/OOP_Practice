public class Calculator {
    private String expression;
    private int operand1;
    private int operand2;
    private int operand3;
    private char operator1;
    private char operator2;
    private boolean exprNoError;

    public Calculator(){expression = null;}
    public Calculator(String expr){setExpression(expr);}

    public void setExpression(String expr) {
        expression = expr;
        exprNoError = parseExpression();
    }
    public String getExpression(){return expression;}
    public boolean getExprNoError(){return exprNoError;}
    public int calculate(){
        int result = Integer.MIN_VALUE;
        if (expression != null && exprNoError) {
            if (operator1 > operator2) {
                result = calc(operator1, operand1, operand2);
                result = calc(operator2, result, operand3);
                return result;
            }
            else {
                result = calc(operator2, operand2, operand3);
                result = calc(operator1, operand1, result);
            }
        }
        return result;
    }
    private int calc(char operator, int operand1, int operand2) { // 사칙연산 구하는 함수
        int result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;

            case '-':
                result = operand1 - operand2;
                break;

            case '*':
                result = operand1 * operand2;
                break;

            case '/':
                result = operand1 / operand2;
                break;

            case '%':
                result = operand1 % operand2;
                break;
        }
        System.out.printf("%d %c %d = %d\n", operand1, operator, operand2, result);
        return result;
    }
    private static int getOperand(String expression, int start, int end) {
        String operandStr = expression.substring(start, end);
        NumString a = new NumString();
        if (!a.isDigit(operandStr)) {
            System.out.println("오류: 피연산자가 숫자가 아님");
            return -1;
        }

        return Integer.parseInt(operandStr);
    }
    private int findOperatorIdx(int start){
        for (int i = start; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/' || currentChar == '%') {
                return i;
            }
        }
        System.out.println("오류: 연산자가 없음");
        return -1;
    }
    private boolean parseExpression() {
        // 초기화
        int start = 0;
        int end = expression.length();
        operand1 = -1;
        operand2 = -1;
        operator1 = ' ';
        operator2 = ' ';

        // 첫 번째 연산자 위치 찾기
        int operatorIndex1 = findOperatorIdx(start);

        // 첫 번째 연산자를 찾지 못하면 오류
        if (operatorIndex1 == -1) {
            System.out.println("오류: 첫 번째 연산자가 없음");
            return false;
        }

        // 두 번째 연산자 위치 찾기
        int operatorIndex2 = findOperatorIdx(operatorIndex1 + 1);

        // 두 번째 연산자를 찾지 못하면 첫 번째 연산자 이후로 계산
        if (operatorIndex2 == -1) {
            operatorIndex2 = end;
        }

        // 첫 번째 피연산자 추출
        operand1 = getOperand(expression, start, operatorIndex1);

        // 두 번째 피연산자 추출
        start = operatorIndex1 + 1;
        operand2 = getOperand(expression, start, operatorIndex2);

        // 피연산자가 유효한지 확인
        if (operand1 == -1 || operand2 == -1) {
            return false;
        }

        // 첫 번째 연산자 추출
        operator1 = expression.charAt(operatorIndex1);

        // 두 번째 연산자 추출
        if (operatorIndex2 < end) {
            operator2 = expression.charAt(operatorIndex2);
        }

        return true;
    }
}
