package week2.methods;

import java.util.Date;

public class Generator {

    /*public static String random_number(int len) {
        String chars = "0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }*/

    public static int randomNumber(int max) {
        int min = 1;
        int random_int = (int) Math.floor(
                Math.random() * (max - min + 1) + min);
        return random_int;
    }

    public static Date getCurrentDate() {
        Date date = new Date();
        return date;
    }

}
