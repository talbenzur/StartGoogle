package week2.lambdas.methods;

import java.time.LocalDate;

import java.util.Random;

import static week2.lambdas.methods.Item.newItem;

class Util {

    public static Item GenerateNewItem() {
        return newItem(generateType(), generateFutureDate(randomNumber(10)), randomNumber(50));
    }

    public static Types generateType() {
        int sizeOfTypes = Types.values().length;
        return Types.values()[randomNumber(sizeOfTypes)];
    }

    public static int randomNumber(int size) {
        return (int) Math.floor(Math.random() * size);
    }

    private static LocalDate generateFutureDate(int numOfDays) {
        return LocalDate.now().plusDays(numOfDays);
    }


    public static String random_name() {
        int len = 6;
        String chars = "abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
}
