package ru.allgoal.tulpan.lesson2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index1")
public class IndexController {
    @RequestMapping(method = RequestMethod.GET)
    public String printStartPage()

    {
        return "index1";
    }


}
