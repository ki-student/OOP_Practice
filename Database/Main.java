import java.util.Scanner;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        boolean tableCreated = false; // 테이블 생성 여부를 추적

        String jdbcUrl = "jdbc:mysql://localhost/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "12345678";
        String filePath = "/Users/giwonjun/desktop/OOR/DB/movie_data.txt";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            Menu menu = new Menu(conn);

            Scanner scanner = new Scanner(System.in);
            boolean isRunning = true;

            while (isRunning) {
                System.out.println("========================================");
                System.out.println("(0) 종료");
                System.out.println("(1) 릴레이션 생성 및 데이터 추가");
                System.out.println("(2) 제목을 이용한 검색");
                System.out.println("(3) 관객수를 이용한 검색");
                System.out.println("(4) 개봉일을 이용한 검색");
                System.out.println("========================================");
                System.out.print("원하는 번호를 입력하시오: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // 개행 문자 처리

                switch (choice) {
                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        isRunning = false;
                        break;
                    case 1:
                        if (tableCreated) {
                            System.out.println("테이블이 이미 생성되었습니다. 다시 생성할 수 없습니다.");
                        } else {
                            menu.createTableAndInsertData(filePath);
                            tableCreated = true; // 테이블 생성 상태 갱신
                        }
                        break;
                    case 2:
                        if (!tableCreated) {
                            System.out.println("먼저 테이블을 생성하십시오.");
                        } else {
                            System.out.print("검색할 제목을 입력하세요: ");
                            String title = scanner.nextLine();
                            menu.searchByTitle(title);
                        }
                        break;
                    case 3:
                        if (!tableCreated) {
                            System.out.println("먼저 테이블을 생성하십시오.");
                        } else {
                            System.out.print("검색할 관객수를 입력하세요: ");
                            int audienceCount = scanner.nextInt();
                            scanner.nextLine(); // 개행 문자 처리
                            menu.searchByAudienceCount(audienceCount);
                        }
                        break;
                    case 4:
                        if (!tableCreated) {
                            System.out.println("먼저 테이블을 생성하십시오.");
                        } else {
                            System.out.print("시작일과 종료일을 입력하세요 (시작일: YYYY-MM-DD, 종료일: YYYY-MM-DD): ");
                            String[] dateRange = scanner.nextLine().split(",");
                            String startDate = dateRange[0].trim();
                            String endDate = dateRange[1].trim();
                            menu.searchByReleaseDate(startDate, endDate);
                        }
                        break;
                    default:
                        System.out.println("0 ~ 4의 숫자 중 선택하세요.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}