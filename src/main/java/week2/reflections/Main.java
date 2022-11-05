package week2.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        Optional<Object> test = newInstanceSingleString(new ClzA("Test"));
        System.out.println(test.isPresent());
        Optional<Object> o = newInstanceSingleString(new ClzB());
        System.out.println(o.isPresent());
    }


    public static Optional<Object> newInstanceSingleString(Object o) throws NoSuchMethodException {
        Class<?> aClass = o.getClass();
        try {
            Constructor<?> constructor = aClass.getConstructor(String.class);
            try {
                Object o1 = constructor.newInstance(Generator.random_name());
                return Optional.of(o1);
            } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
                throw new RuntimeException("Failed to instantiate constructor", e);
            }
        } catch (NoSuchMethodException e) {
            return Optional.empty();
        }
    }
}
