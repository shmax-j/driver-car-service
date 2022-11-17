package taxi.dao.parsing;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetParser<T> {
    T parse(ResultSet resultSet) throws SQLException;
}
