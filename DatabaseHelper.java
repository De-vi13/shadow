import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:librarydb.sqlite";

    public static void createTables() {
        String createBooksTable = "CREATE TABLE IF NOT EXISTS books ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "title TEXT NOT NULL, "
                + "author TEXT NOT NULL, "
                + "isbn TEXT UNIQUE NOT NULL, "
                + "available INTEGER DEFAULT 1"
                + ");";

        try (Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement()) {
            stmt.execute(createBooksTable);
            System.out.println("Database and books table created successfully.");
        } catch (SQLException e) {
            System.err.println("Table creation error: " + e.getMessage());
        }
    }
}
