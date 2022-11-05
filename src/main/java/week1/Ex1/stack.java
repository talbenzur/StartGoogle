package week1.Ex1;

public class stack {
    private int arr[];
    private int size;
    private int index=0;

    public stack(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public void push(int element){
        if(isFull()){
            System.out.println("Error-the stack is full");
        }
        arr[index]=element;
        index++;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Error-the stack is empty");
        }
          index--;
        return arr[index+1];
    }
    public boolean isFull(){
        return(index==size-1);
    }
    public boolean isEmpty(){
        return(index==0);
    }



}
