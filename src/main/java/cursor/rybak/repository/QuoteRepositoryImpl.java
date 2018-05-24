package cursor.rybak.repository;

import cursor.rybak.model.Hero;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class QuoteRepositoryImpl implements QuoteRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public QuoteRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Hero> getHeroes() {
        Query query = sessionFactory
                .createEntityManager()
                .createQuery("SELECT hero.name, hero.quote FROM Hero hero");
        return query.getResultList();
    }

    @Override
    public List<Hero> getHeroQuote(String hero) {
        Query query = sessionFactory
                .createEntityManager()
                .createQuery(String.format("SELECT hero.name, hero.quote FROM Hero hero WHERE hero.name='%s'", hero));
        return query.getResultList();
    }
}
