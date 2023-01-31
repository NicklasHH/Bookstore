package k23.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

	@GetMapping("index")
	@ResponseBody
	public String Tervehdi(@RequestParam(name = "name") String name) {
		return "Moikka " + name;
	}
}