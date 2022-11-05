package week1.Ex1;

import java.util.*;

public class Generator {

    public static String random_User_number(){
        return "121112";
    }

    public static String random_number(int len){
        String chars = "0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static String random_name(int len) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
    public static List<User> generateUserList (int count){
        List<User> users= new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(new User
                    (Generator.random_number(3)
                            ,Generator.random_name(5)));
        }
        return users;
    }


}
