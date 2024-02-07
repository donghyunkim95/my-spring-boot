package com.kitri.springbasicboot.project.rsp_game;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rsp")
public class RspController {
    @GetMapping
    public String home() {
        return "/project/rsp_game/rsp";
    }
}