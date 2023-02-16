package todolist.todolistspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import todolist.todolistspring.service.CalenderService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {
    private final CalenderService calenderService;

    @Autowired
    public TodoController(CalenderService calenderService) {
        this.calenderService = calenderService;
    }

    @GetMapping("todolist") //접근url
    public String login(@RequestParam("id") String id, Model model) {
        model.addAttribute("id", id);
        return "todolist";
    }

    @GetMapping("calender") //접근 url
    public String calenderLoad(Model model) {
        ArrayList<String> cal = calenderService.changeYearMonth(2023, 2);
        ArrayList<String> h_cal = calenderService.renderCalender(cal);
        model.addAttribute("h_cal", h_cal);
        return "calender"; //접근 html
    }

    @GetMapping("hello") //접근url
    public String hello(Model model) {
        return "hello";
    }
}
