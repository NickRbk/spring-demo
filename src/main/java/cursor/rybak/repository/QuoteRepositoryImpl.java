package cursor.rybak.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("quote")
public class QuoteRepositoryImpl implements QuoteRepository {

    @Autowired
    @Qualifier("psql")
    private DataSource dataSource;

    @Override
    public List<String> getQuote() throws SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM heroes");

        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> heroes = new ArrayList<>();

        while (resultSet.next()) {
            heroes.add(resultSet.getString(3));
        }

        return heroes;
    }
}
