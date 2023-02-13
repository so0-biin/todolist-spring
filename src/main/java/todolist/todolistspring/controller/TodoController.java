package todolist.todolistspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {
    @GetMapping("/todo") //접근url
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "todolist";
    }
}
