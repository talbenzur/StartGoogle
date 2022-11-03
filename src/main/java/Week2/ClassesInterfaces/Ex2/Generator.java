package Week2.ClassesInterfaces.Ex2;

import Week2.ClassesInterfaces.Ex2.Animal.Animal;
import Week2.ClassesInterfaces.Ex2.Animal.Gender;

import java.util.Random;

public class Generator {

    public static Gender Random_Gender(){
        int randomNum = (int)Math.floor(Math.random()*(2));
           return Gender.values()[randomNum];
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
    protected static Animal GenerateAnimal(){
        Animal animal=new Animal(Generator.Random_Gender(),
                Integer.parseInt(Generator.random_number(5)),
                Integer.parseInt(Generator.random_number(2)));
        return animal;
    }
}
