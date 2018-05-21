package cursor.rybak.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuoteRepositoryImpl implements QuoteRepository {

    private final DataSource dataSource;

    @Autowired
    public QuoteRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<String> getHeroQuote(String hero) throws SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT quote FROM heroes WHERE name='"
                + hero + "'");

        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> heroVoice = new ArrayList<>();

        while (resultSet.next()) {
            heroVoice.add(resultSet.getString(1));
        }

        if (heroVoice.size()==0) heroVoice.add("HERO NOT FOUND IN DB! CHOOSE ANOTHER CHARACTER!");

        return heroVoice;
    }
}
