import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Minimal JDBC demo: SQLite + students table.
 * Compile/run (adjust JAR name):
 *   javac -cp ".:sqlite-jdbc-3.45.0.0.jar" StudentDbDemo.java
 *   java  -cp ".:sqlite-jdbc-3.45.0.0.jar" StudentDbDemo
 * Windows: use ";." instead of ":." in -cp.
 * See Java-JDBC-Lab-Manual.md in the parent folder.
 */
public class StudentDbDemo {

    private static final String DB_URL = "jdbc:sqlite:students.db";

    public static void main(String[] args) {
        try {
            demo();
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void demo() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            createTableIfNeeded(conn);
            insertSampleRows(conn);
            printAllStudents(conn);
        }
    }

    private static void createTableIfNeeded(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS students ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " name TEXT NOT NULL,"
                + " gpa REAL NOT NULL)";
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
        }
        System.out.println("Table 'students' is ready.");
    }

    private static void insertSampleRows(Connection conn) throws SQLException {
        String sql = "INSERT INTO students (name, gpa) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "Aisha Khan");
            ps.setDouble(2, 3.7);
            ps.executeUpdate();

            ps.setString(1, "Omar Farid");
            ps.setDouble(2, 3.2);
            ps.executeUpdate();
        }
        System.out.println("Inserted sample rows.");
    }

    private static void printAllStudents(Connection conn) throws SQLException {
        String sql = "SELECT id, name, gpa FROM students ORDER BY id";
        try (Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            System.out.println("--- All students ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double gpa = rs.getDouble("gpa");
                System.out.println(id + " | " + name + " | " + gpa);
            }
        }
    }
}
