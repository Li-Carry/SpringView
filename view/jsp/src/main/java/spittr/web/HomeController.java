package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by carry on 17-4-6.
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(method = GET)
    public String home(Model model) {
        return "home";
    }
}
