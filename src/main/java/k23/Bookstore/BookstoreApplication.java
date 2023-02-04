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
	
	repository.save(new Book("Kirja1", "Etunimi Sukunimi1", 2001, "12345-6", 11));
	repository.save(new Book("Kirja2", "Etunimi Sukunimi2", 2002, "23456-7", 22));
	repository.save(new Book("Kirja3", "Etunimi Sukunimi3", 2003, "34567-8", 33));
};
}
}
