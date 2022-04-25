package com.example.laboratoriska_2.DataHolder;

import com.example.laboratoriska_2.model.Author;
import com.example.laboratoriska_2.model.Country;
import com.example.laboratoriska_2.model.enums.Category;
import com.example.laboratoriska_2.service.AuthorService;
import com.example.laboratoriska_2.service.BookService;
import com.example.laboratoriska_2.service.CountryService;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class DataHolder {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;


    public DataHolder(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData() {

        Country contry1 = countryService.save("Great Britain", "Europe").get();
        Country contry2 =  countryService.save("Canada", "North America").get();

        Author author1 = authorService.save("George", "Orwell", contry1.getId()).get();
        Author author2 = authorService.save("Yann", "Martel", contry2.getId()).get();

        bookService.save("1984", Category.FANTASY,  author1.getId(), 100);
        bookService.save("Life of Pi", Category.FANTASY,  author2.getId(), 200);
    }
}
