package k23.Bookstore.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import k23.Bookstore.domain.Book;
import k23.Bookstore.domain.BookRepository;
import k23.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("booklist")
	public String showBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";
	}

	@GetMapping("addBook")
	public String addBook(Model model) {
		model.addAttribute("addBook", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addBook";
	}

	@GetMapping("delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookRepository.deleteById(id);
		return "redirect:/booklist";
	}

	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editBook", bookRepository.findById(id));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editBook";
	}

	@PostMapping("saveBook")
	public String saveBook(@Valid @ModelAttribute("addBook") Book book, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("erroria pukkas");
			return "addBook";
		}

		bookRepository.save(book);
		return "redirect:booklist";

	}
}