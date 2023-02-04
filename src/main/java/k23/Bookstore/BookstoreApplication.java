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

	// string title, author, isbn
	//double price
	// int publicationYear
	
	repository.save(new Book("Otsikko1", "tekijä1", 2001, "isbn1", 11));
	repository.save(new Book("Otsikko2", "tekijä2", 2002, "isbn2", 22));
	repository.save(new Book("Otsikko3", "tekijä3", 2003, "isbn3", 33));
};
}
}
