package week1.ex1;

/*
public class StackT<T> {
    T[] elements;
    int count;

    public StackT(int initSize) {
        this.elements = (T[]) new Object[initSize];
        count = 0;
    }

    public void Push(T newElement) {
        if (count < elements.length - 1) {
            elements[count] = newElement;
        } else {
            T[] resizedArray = (T[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, resizedArray, 0, elements.length);
            elements = resizedArray;
            resizedArray = null;
            elements[count] = newElement;
        }

        count++;
    }
}
*/