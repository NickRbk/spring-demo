package cursor.rybak.repository;

import cursor.rybak.model.Hero;

import java.util.List;

public interface QuoteRepository {
    List<Hero> getHeroes();
    List<Hero> getHeroQuote(String hero);
}
