package me.nick_lin.test_baidu_api.Controller;

import me.nick_lin.test_baidu_api.Services.TranslationService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TranContent")
public class TranslationController {

    @PostMapping("/Request")
    public JSONObject translate(@RequestParam("query") String query,
                                @RequestParam("from") String from,
                                @RequestParam("to") String to) {
        return TranslationService.translate(query, from, to);
    }
}
