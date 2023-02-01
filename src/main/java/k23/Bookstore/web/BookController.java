package k23.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import k23.Bookstore.domain.Book;
import k23.Bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepository;

	@GetMapping("booklist")
	public String showBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}

	@GetMapping("addbook")
	public String addBook(Model model) {
		model.addAttribute("addbook", new Book());
		return "addbook";
	}

	@PostMapping("saveBook")
	public String saveBook(Book book) {
		bookRepository.save(book);
		return "redirect:booklist";
	}
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model){ 
	bookRepository.deleteById(id);
	return "redirect:../booklist";
	}

}