package k23.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k23.Bookstore.domain.Book;
import k23.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}



@Bean
public CommandLineRunner demo(BookRepository repository) {return (args) -> {

	repository.save(new Book("Otsikko1", "tekijä1", "julkaisuvuosi1", "isbn1", "hinta1"));
	repository.save(new Book("Otsikko2", "tekijä2", "julkaisuvuosi2", "isbn2", "hinta2"));
	repository.save(new Book("Otsikko3", "tekijä3", "julkaisuvuosi3", "isbn3", "hinta3"));
};
}
}
