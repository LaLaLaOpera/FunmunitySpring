package com.funmunity.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WritingController {
    @GetMapping("**/post")
    public String postWriting(){


        return "postUpload";
    }
}
