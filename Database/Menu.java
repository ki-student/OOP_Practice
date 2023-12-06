import java.sql.*;
import java.io.*;

public class Menu {

    private Connection conn;

    public Menu(Connection conn) {
        this.conn = conn;
    }

    public void createTableAndInsertData(String filepath) {
        // Create a new table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS movies ("
                + "id CHAR(3) PRIMARY KEY,"
                + "title VARCHAR(100),"
                + "company VARCHAR(50),"
                + "releasedate DATE,"
                + "country VARCHAR(10),"
                + "totalscreen INT,"
                + "profit NUMERIC(15,2),"
                + "totalnum INT,"
                + "grade VARCHAR(50)"
                + ")";

        try (PreparedStatement stmt = conn.prepareStatement(createTableSQL)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Table created");

        // Insert data from the file
        int totalRowsInserted = 0;  // 총 삽입된 레코드 수를 저장할 변수
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.substring(1).split("\\|");
                if (data.length == 9) {
                    String id = data[0].trim();
                    String title = data[1].trim();
                    String company = data[2].trim();
                    String releaseDate = data[3].trim();
                    String country = data[4].trim();
                    int totalScreen = Integer.parseInt(data[5].trim());
                    double profit = Double.parseDouble(data[6].trim());
                    int totalNum = Integer.parseInt(data[7].trim());
                    String grade = data[8].trim();

                    String insertDataSQL = "INSERT INTO movies (id, title, company, releasedate, country, totalscreen, profit, totalnum, grade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement insertStmt = conn.prepareStatement(insertDataSQL)) {
                        insertStmt.setString(1, id);
                        insertStmt.setString(2, title);
                        insertStmt.setString(3, company);
                        insertStmt.setString(4, releaseDate);
                        insertStmt.setString(5, country);
                        insertStmt.setInt(6, totalScreen);
                        insertStmt.setDouble(7, profit);
                        insertStmt.setInt(8, totalNum);
                        insertStmt.setString(9, grade);
                        int rowsAffected = insertStmt.executeUpdate();
                        totalRowsInserted += rowsAffected;  // 삽입된 레코드 수를 누적하여 저장
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(totalRowsInserted + " row(s) inserted");
    }

    public void searchByTitle(String title) throws SQLException {
        String query = "SELECT * FROM movies WHERE title LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, "%" + title + "%");
            try (ResultSet result = stmt.executeQuery()) {
                while (result.next()) {
                    System.out.println("|" + result.getString("id") + "|"
                            + result.getString("title") + "|"
                            + result.getString("company") + "|"
                            + result.getDate("releasedate") + "|"
                            + result.getString("country") + "|"
                            + result.getInt("totalscreen") + "|"
                            + result.getBigDecimal("profit") + "|"
                            + result.getInt("totalnum") + "|"
                            + result.getString("grade") + "|");
                }
            }
        }
    }

    public void searchByAudienceCount(int audienceCount) throws SQLException {
        String query = "SELECT * FROM movies WHERE totalnum > ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, audienceCount);
            try (ResultSet result = stmt.executeQuery()) {
                while (result.next()) {
                    System.out.println("|" + result.getString("id") + "|"
                            + result.getString("title") + "|"
                            + result.getString("company") + "|"
                            + result.getDate("releasedate") + "|"
                            + result.getString("country") + "|"
                            + result.getInt("totalscreen") + "|"
                            + result.getBigDecimal("profit") + "|"
                            + result.getInt("totalnum") + "|"
                            + result.getString("grade") + "|");
                }
            }
        }
    }

    public void searchByReleaseDate(String startDate, String endDate) throws SQLException {
        String query = "SELECT * FROM movies WHERE releasedate BETWEEN ? AND ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, startDate);
            stmt.setString(2, endDate);
            try (ResultSet result = stmt.executeQuery()) {
                while (result.next()) {
                    System.out.println("|" + result.getString("id") + "|"
                            + result.getString("title") + "|"
                            + result.getString("company") + "|"
                            + result.getDate("releasedate") + "|"
                            + result.getString("country") + "|"
                            + result.getInt("totalscreen") + "|"
                            + result.getBigDecimal("profit") + "|"
                            + result.getInt("totalnum") + "|"
                            + result.getString("grade") + "|");
                }
            }
        }
    }
}