package cursor.rybak.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class QuoteRepositoryImpl implements QuoteRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<String> getHeroQuote(String hero) {

        Query query = sessionFactory
                .createEntityManager()
                .createQuery("SELECT hero from cursor.rybak.model.Hero hero");

        return query.getResultList();
//        Connection connection = dataSource.getConnection();
//
//        PreparedStatement preparedStatement = connection.prepareStatement("SELECT quote FROM heroes WHERE name='"
//                + hero + "'");
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        List<String> heroVoice = new ArrayList<>();
//
//        while (resultSet.next()) {
//            heroVoice.add(resultSet.getString(1));
//        }
//
//        if (heroVoice.size()==0) heroVoice.add("HERO NOT FOUND IN DB! CHOOSE ANOTHER CHARACTER!");
//
//        return heroVoice;
    }
}
