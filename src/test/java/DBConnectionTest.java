import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.Test;
import taxi.util.ConnectionUtil;

public class DBConnectionTest {
    @Test
    public void testConnection() {
        try (Connection connection
                     = ConnectionUtil.getConnection();
             Statement statement = connection.createStatement();
        ) {
            statement.execute("SHOW tables");
        } catch (SQLException e) {
            throw new RuntimeException("Test failed! Could not connect "
                    + "to db using ConnectionUtils", e);
        }
    }
}
