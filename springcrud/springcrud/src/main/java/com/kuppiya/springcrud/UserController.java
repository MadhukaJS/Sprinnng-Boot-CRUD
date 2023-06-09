package com.kuppiya.springcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService us;

    @RequestMapping("/")
    public String home(Model model){
        Iterable<User> users =us.selectUser();
        model.addAttribute("users",users);
        return "home";
    }

    @RequestMapping("/create")
    public String create(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "newuser";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String savedata(@ModelAttribute("user")User user){
        us.saveUser(user);
        return "redirect:/";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView edituser(@PathVariable("id") Long id){
        ModelAndView modelAndView=new ModelAndView("edituser");
        User user= us.findUser(id);
        modelAndView.addObject("edituser",user);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deluser(@PathVariable("id")Long id){
        us.deleteUser(id);
        return "redirect:/";
    }



}
