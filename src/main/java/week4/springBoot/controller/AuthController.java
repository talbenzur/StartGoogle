package week4.springBoot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import week4.springBoot.service.AuthenticationService;

import static week4.springBoot.controller.UtilController.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private static AuthenticationService authService= new AuthenticationService();

    @RequestMapping(method = RequestMethod.POST, path= "/register")
    public static Long registerNewUser(@RequestParam String email,@RequestParam String name, @RequestParam String password){
        if(!checkEmailValid(email)){
            System.out.println("Invalid Email");
            return null;
        }
        if(!checkNameValid(name)){
            System.out.println("Invalid Name");
            return null;
        }
        if(!checkPasswordValid(password)){
            System.out.println("Invalid Password. Must include minimum eight characters, " +
                    "at least one letter and one number");
            return null;
        }

        return authService.createUser(email, name, password);
    }

    @RequestMapping(method = RequestMethod.GET, path= "/login")
    public static Long login(@RequestParam String email,@RequestParam String password){
        if(!checkEmailValid(email)){
            System.out.println("email field invalid");
            return null;
        }

        Long token=authService.logIn(email, password);
        System.out.println("Logged In Successfully");
        return token;
    }


}
