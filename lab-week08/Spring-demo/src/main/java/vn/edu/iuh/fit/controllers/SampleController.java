package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.services.SampleService;

@Controller
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    private SampleService service;
    @RequestMapping(value = {"/index", "/default", "/home"})
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("a", 0);
        mav.addObject("b", 0);
        mav.addObject("result", 0);
        return mav;
    }
//    @RequestMapping("/sum")
//    public void doFoo(Model model){
//        model.addAttribute("a",3.3);
//        model.addAttribute("b",4.5);
//        double a = Double.parseDouble(model.getAttribute("a").toString());
//        double b = Double.parseDouble(model.getAttribute("b").toString());
//        model.addAttribute("result", service.Sum(a,b));
//
//    }

    @PostMapping("/sum")
    public ModelAndView doFoo(@RequestParam("a") double a, @RequestParam("b") double b) {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("a", a);
        mav.addObject("b", b);
        mav.addObject("result", service.Sum(a, b));
        return mav;
    }
}
