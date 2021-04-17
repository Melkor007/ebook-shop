package simplecrud.controller;

//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import simplecrud.service.UserService;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

    @Autowired
    private HttpServletRequest req;

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/","/index"})
    public String root() {
    	
        return "redirect:/login";
    }

//    @GetMapping("/login")
//    public String login(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (!(auth instanceof AnonymousAuthenticationToken))
//    		 return "redirect:/book-list";
//
//        else
//	         return "login";
//
//    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String fuckit(){
        String username = req.getParameter("username");
        String user_password = req.getParameter("user_password");
        boolean correct = userService.login(username,user_password);
        if(correct){
            if (userService.checkRole(username).getId() == 0)
                return "redirect:/book-list";
            else
                return "redirect:/managerView";
        }
        else{
            return "login";
        }
    }


//    @GetMapping(value="/logout")
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "login";
//    }

}
