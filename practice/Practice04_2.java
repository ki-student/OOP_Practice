import java.util.Objects;
import java.util.Scanner;
public class Practice04_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("회원 등급 : ");
        String level = sc.next();
        System.out.print("주차 시간(분) : ");
        int time = sc.nextInt();

        int fee = 0;
        int additionalfee;

        // 플래티넘 이거나 골드인 경우
        if ((Objects.equals(level, "플래티넘")) || (Objects.equals(level, "골드"))){
            if (time <= 120) {
                System.out.printf("주차 요금은 %d원 입니다.", fee);
            }// 2시간 이내
            else {
                additionalfee = ((time - 120) / 10) * 1000;
                fee += additionalfee;
                System.out.printf("주차 요금은 %d원 입니다.", fee);
            }
        }
        // 실버/프렌즈인 경우
        else if (Objects.equals(level, "실버") || Objects.equals(level, "프렌즈")){
            System.out.print("구매 금액 : ");
            int price = sc.nextInt();
            if (price >= 10000 && price < 30000){
                if (time <= 60){
                    System.out.printf("주차 요금은 %d원 입니다.", fee);
                }//만원 이상 이고 60분 이내
                else{
                    additionalfee = ((time - 60) / 10) * 1000;
                    fee += additionalfee;
                    System.out.printf("주차 요금은 %d원 입니다.", fee);
                }
            } else if (price >= 30000){
                if (time <= 120){
                    System.out.printf("주차 요금은 %d원 입니다.", fee);
                }// 3만원 이상 이고 120분 이내
                else {
                    additionalfee = ((time - 120) / 10) * 1000;
                    fee += additionalfee;
                    System.out.printf("주차 요금은 %d원 입니다.", fee);
                }
            }else{
                fee = (time / 10) * 1000;
                System.out.printf("주차 요금은 %d원 입니다.", fee);
            }//범위 내의 값이 아닌 경우
        }
        //비회원인 경우
        if (Objects.equals(level, "비회원")){
            System.out.print("구매 금액 : ");
            int price = sc.nextInt();
            if (price >= 30000 && price < 50000){
                if (time <= 60){
                    System.out.printf("주차 요금은 %d원 입니다.", fee);
                }//3만원 이상 구매 하고 60분 이내인 경우
                else{
                    additionalfee = ((time - 60) / 10) * 1000;
                    fee += additionalfee;
                    System.out.printf("주차 요금은 %d원 입니다.", fee);
                }
            } else if (price >= 50000){
                if (time <= 120){
                    fee = 0;
                    System.out.printf("주차료 = %d", fee);
                }//5만원 이상 구매 하고 120분 이내인 경우
                else {
                    additionalfee = ((time - 120) / 10) * 1000;
                    fee += additionalfee;
                    System.out.printf("주차료 = %d", fee);
                }
            }else{
                fee = (time / 10) * 1000;
                System.out.printf("주차료 = %d", fee);
            }//3만원 이상 구매를 하지 않은 경우
        }
    }
}
