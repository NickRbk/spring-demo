package cursor.rybak.repository;

import java.sql.SQLException;
import java.util.List;

public interface QuoteRepository {

    List<String> getQuote() throws SQLException;
}
