public class LicensePlate{
    //201910885,기원준,아무일도없었다
    private String number;
    private boolean parseError;
    private int firstNum;
    private int secondNum;
    private char hangul;
    private char[] hangulArr;

    public LicensePlate(char[] hangulArr){
        number = null;
        parseError = false;
        this.hangulArr = hangulArr;
    }
    public LicensePlate(String num, char[] hangulArr) {
        parseError = false;
        number = num;
        this.hangulArr = hangulArr;
    }
    public void setNumber(String num){
        number = num;
        parseError = !parseNumber();
    }
    public boolean getParseError(){return parseError;}
    public void printInfo(){
        printType(firstNum);
        printUsage(hangul);
    }
    public boolean parseNumber() {
        if (number != null) {
            firstNum = getFirstNumber();
            if (firstNum == -1) {
                return false;
            }
            int korIdx = -1;
            int spaceIdx = -1;
            if (firstNum >= 100) {
                korIdx = 3;
                spaceIdx = 4;
            }
            else {
                korIdx = 2;
                spaceIdx = 3;
            }
            char ch = number.charAt(korIdx);
            boolean found = false;
            for (char h : hangulArr) {
                if (h == ch) {
                    hangul = ch;
                    found = true;
                    break;
                }
            }
            if (found == false) {
                System.out.println("오류: 사용할 수 없는 한글입니다");
                return false;
            }
            if (number.charAt(spaceIdx) != ' ') {
                System.out.println("오류: 앞 번호와 뒷 번호 사이에 공백이 없습니다");
                return false;
            }
            secondNum = getSecondNumber(spaceIdx + 1);
            if (secondNum == -1) {
                return false;
            }
            return true;
        }
        else {
            System.out.println("오류: 자동차 번호가 지정되지 않았습니다");
        }
        return false;
    }
    private int getSecondNumber(int idx) {
        String num = number.substring(idx);
        if (num.length() != 4) {
            System.out.println("오류: 뒷번호 길이가 너무 길거나 짧습니다");
            return -1;
        }
        int n;
        if (NumString.isDigit(num)) {
            n = Integer.parseInt(num);
            if (n >= 100) {
                return n;
            }
            System.out.println("오류: 뒷번호가 100 미만입니다");
        }
        else {
            System.out.println("오류: 뒷번호가 숫자가 아닙니다");
        }
        return -1;
    }

    private int getFirstNumber() {
        String num = number.substring(0, 3);
        int n;
        if (NumString.isDigit(num)) {
            n = Integer.parseInt(num);
            if (n >= 100) {
                return n;
            }
            System.out.println("오류: 앞 번호가 100 미만입니다");
            return -1;
        }
        System.out.println("오류: 앞 번호에 숫자가 아닌 것이 있습니다");
        return -1;
    }
    private void printType(int num) {
        if (num <= 69 || (num >= 100 && num <= 699)) {
            System.out.println("종류: 승용차");
        }
        else if ((num >= 70 && num <= 79) || (num >= 700 && num <= 799)) {
            System.out.println("종류: 승합차");
        }
        else if ((num >= 80 && num <= 97) || (num >= 800 && num <= 979)) {
            System.out.println("종류: 화물차");
        }
        else if (num == 98 || num == 99 || (num >= 980 && num <= 999)) {
            System.out.println("종류: 특수차");
        }
    }
    private void printUsage(char ch) {
        char[] arr1 = { '가', '나', '다', '라', '마',
                '거', '너', '더', '러', '머', '버', '서', '어', '저',
                '고', '노', '도', '로', '모', '보', '소', '오', '조',
                '구', '누', '두', '루', '무', '수', '우', '주' };
        for (char c : arr1) {
            if (c == ch) {
                System.out.println("용도: 비사업용");
            }
        }
        if (ch == '바' || ch == '사' || ch == '아' || ch == '자') {
            System.out.println("용도: 사업용(택시)");
        }
        if (ch == '배') {
            System.out.println("용도: 사업용(택배)");
        }
        if (ch == '하' || ch == '허' || ch == '호') {
            System.out.println("용도: 사업용(렌터카/리스)");
        }
    }
}