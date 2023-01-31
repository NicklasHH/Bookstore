package k23.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

	@GetMapping("index")
	@ResponseBody
	public String Tervehdi(@RequestParam(name = "name", required=false) String name){
		if (name == null) {
			return "Moikka! syötä ihmeessä nimesi seuraavalla tavalla: "
					+ "<br> http://localhost:8080/index?name=nimesi";
		}
		
		else {
			return "Moikka " + name + "!";
		}
	}
}
