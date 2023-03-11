package k23.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import k23.Bookstore.domain.Book;
import k23.Bookstore.domain.BookRepository;

@DataJpaTest
class BookRepositoryTests {
	@Autowired
	BookRepository bookRepository;

	@Test
	public void findTitle() {
		List<Book> book = bookRepository.findByTitle("Kirja1");
		assertThat(book.get(0).getTitle().equals("Kirja1"));
	}

	@Test
	public void saveBook() {
		Book book = new Book("Kirja1", "Etunimi Sukunimi1", 2001, "12345-6", 11.1);
		bookRepository.save(book);
		assertNotEquals(book.getId(), null);
	}

	@Test
	public void deleteBook() {
		List<Book> books = bookRepository.findByTitle("Kirja1");
		Book book = books.get(0);
		
		bookRepository.delete(book);

		List<Book> newBook = bookRepository.findByTitle("Kirja1");
		assertThat(newBook).hasSize(0);
	}

}
