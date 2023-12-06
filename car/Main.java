public class Main {
    public static void main(String[] args) {
        char[] hangulArr = {'가', '나', '다', '라', '마',
                '거', '너', '더', '러', '머', '버', '서', '어', '저',
                '고', '노', '도', '로', '모', '보', '소', '오', '조',
                '구', '누', '두', '루', '무', '수', '우', '주', '바',
                '사', '아', '자', '배', '하', '허', '호'};

        String[] nums = {"100가 11111", "1가  1111", "000가 1111",
                "000가 1111", "100 가1111", "100가1111 ", "100가 0011",
                "150히 1111", "01가 1111", "200하 1111", "150배 1111",
                "150누 1111"};

        LicensePlate plate = new LicensePlate(hangulArr);
        for (String n : nums) {
            System.out.println("\n" + n);
            plate.setNumber(n);
            if (plate.getParseError() == false) {
                plate.printInfo();
            }
        }
    }
}