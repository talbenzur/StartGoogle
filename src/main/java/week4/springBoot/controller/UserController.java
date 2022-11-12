package week4.springBoot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import week4.springBoot.service.UserService;

import static week4.springBoot.controller.UtilController.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private static UserService userService= new UserService();

    @RequestMapping(method = RequestMethod.PUT, value = "/updateEmail")
    public static void updateUserEmail(@RequestHeader("token") Long token,@RequestParam String email){
        if (!checkEmailValid(email)){
            System.out.println("Invalid Email for update");
        } else {
            userService.updateEmail(token, email);
        }
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/updateName")
    public static void updateUserName(@RequestHeader("token") Long token,@RequestParam String name){
        if (!checkNameValid(name)){
            System.out.println("Invalid Name for update");
        } else {
            userService.updateName(token, name);
        }
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/updatePassword")
    public static void updateUserPassword(@RequestHeader("token")Long token, @RequestParam String password){
        if(!checkPasswordValid(password)){
            System.out.println("Invalid Password for update");
        } else {
            userService.userUpdatePassword(token, password);
        }
    }
    @RequestMapping(method = RequestMethod.DELETE,value="/delete")
    public static void deleteUser(@RequestHeader("token") Long token){
        userService.deleteUser(token);
    }
}
