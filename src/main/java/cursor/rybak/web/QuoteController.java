package cursor.rybak.web;

import cursor.rybak.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuoteController {

    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteController(@Qualifier(value = "quote") QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @GetMapping
    public List<String> getQuote() throws SQLException {
        return quoteRepository.getQuote();
    }

}
