package k23.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k23.Bookstore.domain.Book;
import k23.Bookstore.domain.BookRepository;
import k23.Bookstore.domain.Category;
import k23.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			// string name
			categoryRepository.save(new Category("kategoria1"));
			categoryRepository.save(new Category("kategoria2"));
			categoryRepository.save(new Category("kategoria3"));

			// string title, author, isbn
			// double price
			// int publicationYear

			// String title, String author, int publicationYear, String isbn, double price
			bookRepository.save(new Book("Kirja1", "Etunimi Sukunimi1", 2001, "12345-6", 5555.66, categoryRepository.findByName("kategoria1").get(0)));
			bookRepository.save(new Book("Kirja2", "Etunimi Sukunimi2", 2002, "23456-7", 22.5, categoryRepository.findByName("kategoria1").get(0)));
			bookRepository.save(new Book("Kirja3", "Etunimi Sukunimi3", 2003, "34567-8", 33));

		};
	}
}
