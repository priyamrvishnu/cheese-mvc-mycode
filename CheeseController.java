package org.launchcode.cheesemvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static HashMap<String, String>cheeses = new HashMap<>();

    //  /Request path:/cheese
    @RequestMapping(value="")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST) 
    public String processAddChesseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription){
        cheeses.put(cheeseName,cheeseDescription);
        return "redirect:";

    }
    @RequestMapping(value ="remove", method = RequestMethod.GET)
    public String removeCheeseForm(Model model){
        model.addAttribute("title","Remove Cheese");
        return "cheese/remove";
    }
    @RequestMapping(value="remove", method = RequestMethod.POST)
    public String removeCheeseDisplay(@RequestParam String cheeseName) {
        /*String remChesse = cheeses.get(Key);*/
        for (String key : cheeses.keySet()) {
            if(key.contains(cheeseName)){
                cheeses.remove(cheeseName);
            }
        }return "redirect:";
    }
}
