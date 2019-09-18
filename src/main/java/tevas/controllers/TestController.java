/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tevas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Cerephenien
 */
@Controller
public class TestController {
    
    @GetMapping ("*")
    public String test() {
        return "index";
    }
}
