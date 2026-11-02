import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Opens connections to the auction database. */
public class conectaDAO {

    private static final String DEFAULT_URL = "jdbc:mysql://localhost/uc11";
    private static final String DEFAULT_USER = "root";

    public Connection connectDB() throws SQLException {
        String url = valueOrDefault("LEILOES_DB_URL", DEFAULT_URL);
        String user = valueOrDefault("LEILOES_DB_USER", DEFAULT_USER);
        String password = System.getenv("LEILOES_DB_PASSWORD");
        if (password == null) {
            password = "";
        }
        return DriverManager.getConnection(url, user, password);
    }

    private String valueOrDefault(String key, String fallback) {
        String value = System.getenv(key);
        return value == null || value.isBlank() ? fallback : value;
    }
}
