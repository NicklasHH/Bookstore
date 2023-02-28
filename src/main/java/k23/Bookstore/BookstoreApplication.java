package k23.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import k23.Bookstore.domain.Book;
import k23.Bookstore.domain.BookRepository;
import k23.Bookstore.domain.Category;
import k23.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Autowired
	BookRepository bookRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			// string name
			log.info("lisätään kategoriat");
			categoryRepository.save(new Category("kategoria1"));
			categoryRepository.save(new Category("kategoria2"));
			categoryRepository.save(new Category("kategoria3"));

			log.info("lisätään kirjat");
			// String title, String author, int publicationYear, String isbn, double price
			bookRepository.save(new Book("Kirja1", "Etunimi Sukunimi1", 2001, "12345-6", 11.1, categoryRepository.findByName("kategoria1").get(0)));
			bookRepository.save(new Book("Kirja2", "Etunimi Sukunimi2", 2002, "23456-7", 22.22, categoryRepository.findByName("kategoria2").get(0)));
			bookRepository.save(new Book("Kirja3", "Etunimi Sukunimi3", 2003, "34567-8", 33,categoryRepository.findByName("kategoria3").get(0)));
			bookRepository.save(new Book("Kirja4", "Etunimi Sukunimi4", 2004, "45678-9", 44.44));
			
			log.info("tulostetaan kirjat"); 
			  for (Book book : bookRepository.findAll()) { 
				  log.info(book.toString()); }
		};
	}
}
