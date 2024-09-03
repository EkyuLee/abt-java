package com.jtre;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "redirect:/index.html";
    }

    @GetMapping("/go-post-page")
    public String goPostPage() {
        return "redirect:/post-page.html";
    }
}
