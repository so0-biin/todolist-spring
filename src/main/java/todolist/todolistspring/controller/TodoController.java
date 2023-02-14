package todolist.todolistspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {
    @GetMapping("todolist") //접근url
    public String login(@RequestParam("id") String id, Model model) {
        model.addAttribute("id", id);
        return "todolist";
    }

    @GetMapping("calender") //접근 url
    public String calenderLoad() {
        return "calender"; //접근 html
    }

    @GetMapping("/hello") //접근url
    public String hello() {
        return "hello";
    }
}
