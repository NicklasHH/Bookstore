package k23.Bookstore.web;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/books")
	public Iterable<Book> getBook(){
		Log.info("//fetch and return books");
		return bookRepository.findAll();
	}

	//hae id perusteella 1 kirja
	@GetMapping("/book{id}")
	Optional<Book> getBook(@PathVariable Long id) {
		Log.info("find book, id = " + id);
		return bookRepository.findById(id);
	}
	
}
