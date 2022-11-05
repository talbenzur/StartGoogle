package week1.ex1;

public class Loops {

    public static void Loop_foreach(int[] numbers, int num) {
        for (int number : numbers) {
            if (number % num == 0) {
                System.out.println(number);
            }
        }
    }

    public static void Loop_for(int[] numbers, int num) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % num == 0) {
                System.out.println(numbers[i]);
            }
        }
    }

    public static void Loop_while(int[] numbers, int num) {
    int size= numbers.length;
    int i=0;
    while(i<size){
        if (numbers[i] % num == 0) {
            System.out.println(numbers[i]);
        }
        i++;
    }
    }

}
