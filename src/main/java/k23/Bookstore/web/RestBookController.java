package k23.Bookstore.web;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import k23.Bookstore.domain.Book;
import k23.Bookstore.domain.BookRepository;

@RestController
public class RestBookController {
	
	private static final Logger Log = LoggerFactory.getLogger(RestBookController.class);
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	

	// hae ja palauta kirjat
	@GetMapping("/2books")
	public Iterable<Book> getBook(){
		Log.info("//fetch and return books");
		return bookRepository.findAll();
	}

	//hae id perusteella 1 kirja
	@GetMapping("/2book{id}")
	Optional<Book> getBook(@PathVariable Long id) {
		Log.info("find book, id = " + id);
		return bookRepository.findById(id);
	}
	
	// Kirjan lisäys
	@PostMapping("2books")
	Book newBook(@RequestBody Book newBook) {
		return bookRepository.save(newBook);
	}
	
	// kirjan poisto
	@DeleteMapping("/2books/{id}")
	public Iterable<Book> deleteBook(@PathVariable Long id) {
		bookRepository.deleteById(id);
		return bookRepository.findAll();
	}
	
	// Kirjan muokkaus
	@PutMapping("/2books/{id}")
	Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
		editedBook.setId(id);
		return bookRepository.save(editedBook);
	}
	
	
}