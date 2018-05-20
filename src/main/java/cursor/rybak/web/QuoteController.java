package cursor.rybak.web;

import cursor.rybak.repository.QuoteRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuoteController {

    @Getter
    @Autowired
    @Qualifier("quote")
    private QuoteRepository quoteRepository;

    @GetMapping
    public List<String> getQuote() throws SQLException {

        quoteRepository.getQuote().forEach(System.out::println);

//        return Arrays.asList("Nick", "Olga", "Mike");
        return quoteRepository.getQuote();
//        return "HelloWorld from API";
    }

}
