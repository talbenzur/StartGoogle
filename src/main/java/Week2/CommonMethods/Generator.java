package Week2.CommonMethods;

import Week1.GeneralProgramming.Player;

import java.util.Random;

public class Generator {

    public static Prefix Random_prefix(){
        int randomNum = (int)Math.floor(Math.random()*(4));
           return Prefix.values()[randomNum];
    }


    public static String random_number(int len){
        String chars = "0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static String random_name() {
        int len=6;
        String chars = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
}
