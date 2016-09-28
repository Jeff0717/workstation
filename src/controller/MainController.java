package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/Main")
public class MainController {
	private static final String MAIN_PAGE = "main";
	
	@RequestMapping(method = {RequestMethod.GET})
    public String Main(Model model){
		return MAIN_PAGE;
	}
}
