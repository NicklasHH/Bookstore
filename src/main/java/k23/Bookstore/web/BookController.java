package k23.Bookstore.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import k23.Bookstore.domain.Book;
import k23.Bookstore.domain.BookRepository;
import k23.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	private static final Logger Log = LoggerFactory.getLogger(BookController.class);

	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping(value = { "/", "index" })
	public String ShowMainPage() {
		return "redirect:booklist";
	}

	@GetMapping("booklist")
	public String showBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("addBook")
	public String addBook(Model model) {
		model.addAttribute("addBook", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addBook";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookRepository.deleteById(id);
		return "redirect:/booklist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editBook", bookRepository.findById(id));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editBook";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("saveBook")
	public String saveBook(@Valid @ModelAttribute("addBook") Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("erroria pukkas");
			return "addBook";
		}

		bookRepository.save(book);
		return "redirect:booklist";

	}

	// REST OSIO
	// hae ja näytä kirjat
	@GetMapping("/books")
	public @ResponseBody List<Book> showRestBook() {
		Log.info("showRestOwners");
		return (List<Book>) bookRepository.findAll();
	}

	//hae id perusteella 1 kirja
	@GetMapping("/book{id}")
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {
		return bookRepository.findById(id);
	}
}