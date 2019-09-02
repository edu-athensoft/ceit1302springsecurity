package com.athensoft.demo.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller  
public class HomeController {  
      
    @RequestMapping(value="/", method=RequestMethod.GET)  
    public String home() {  
        return "home";  
    }  
      
    @RequestMapping(value="/admin", method=RequestMethod.GET)  
    public String adminHome() {  
        return "admin-page";  
    }  
    
    @RequestMapping(value="/member", method=RequestMethod.GET)  
    public String memberHome() {  
        return "member-page";  
    } 
    
    @RequestMapping(value="/login", method=RequestMethod.GET)  
    public String gotoLogin() {  
        return "login";  
    }
    
    @RequestMapping(value="/logout", method=RequestMethod.POST)  
    public String gotoLogout(HttpServletRequest request, HttpServletResponse response) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/";   
    }
    
    @RequestMapping(value="/welcome", method=RequestMethod.GET)  
    public String gotoWelcome(Model model) {  
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal instanceof String ?
                (String) principal :
                (principal instanceof UserDetails ? ((UserDetails) principal).getUsername() : "");
        model.addAttribute("username",username);
        return "welcome";  
    } 
    
    @RequestMapping(value="/403", method=RequestMethod.GET)  
    public String goto403() {  
        return "403";  
    } 
}  
