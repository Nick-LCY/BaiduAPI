package me.nick_lin.test_baidu_api.Controller;

import me.nick_lin.test_baidu_api.Services.TranslationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/Translation")
public class TranslationController {

    @PostMapping("/Request")
    public String translate(@RequestParam("query") String query,
                                @RequestParam("from") String from,
                                @RequestParam("to") String to) {
        return TranslationService.translate(query, from, to);
    }

    @GetMapping("/MainPage")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("/MainPage");
        return modelAndView;
    }
}