package week2.generics;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

//Write a generic method that gets a Callable<T>
// and runs it until an expected result is returned or a given retry count is reached.
//The method should return the final result it got even if it is not the expected one.
//The method should be provided with number of retries and sleep between retries.
//The method should have overloads that have default sleeps and retry limits.
public class Main {
    public static void main(String[] args) {


        Callable<String> stringCallable = new Callable<>() {
            @Override
            public String call() throws Exception {
                return "Shalom";
            }
        };
        Callable<Double> doubleCallable = new Callable<>() {
            @Override
            public Double call() throws Exception {
                return ThreadLocalRandom.current().nextDouble(10);
            }
        };

        String str = retry(stringCallable, "Shalom", 5, 1000);
        String str2 = retry(stringCallable, "Shalom", 5);
        String str3 = retry(stringCallable, "Shalom");
        System.out.println("str1: " + str + "\nstr2: " + str2 + "\nstr3: " + str3);
        Double double1 = retry(doubleCallable, 5.0, 3, 2000);
        Double double2 = retry(doubleCallable, 5.0, 3);
        Double double3 = retry(doubleCallable, 5.0);
        System.out.println("double1: " + double1 + "\ndouble2: " + double2 + "\ndouble3: " + double3);


    }

    public static <T> T retry(Callable<T> action, T expectedResult, int retryTimes, int sleepTime) {
        T result = null;//how to implement with optional?
        do {
            try {
                result = action.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retryTimes--;

        } while (retryTimes > 0 && expectedResult != result);


        return result;
    }

    public static <T> T retry(Callable<T> action, T expectedResult, int retryTimes) {
        int sleepTime = randomNumber(1000, 5000);


        return retry(action, expectedResult, retryTimes, sleepTime);
    }

    public static <T> T retry(Callable<T> action, T expectedResult) {
        int sleepTime = randomNumber(1000, 5000);
        int retryTimes = randomNumber(1, 10);

        return retry(action, expectedResult, retryTimes, sleepTime);
    }

    public static int randomNumber(int min, int max) {
        int random_int = (int) Math.floor(
                Math.random() * (max - min + 1) + min);
        return random_int;
    }
}