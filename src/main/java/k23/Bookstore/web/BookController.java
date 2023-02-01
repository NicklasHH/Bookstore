package k23.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import k23.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepository;

}