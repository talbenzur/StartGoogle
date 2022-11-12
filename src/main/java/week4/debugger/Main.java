package week4.debugger;

public class Main {
    public static void main(String[] args) {
        int n=101, sum,r;
        sum=0;
        while (n > 0) {
            r = n % 10;
            Debugger.log(r);
            sum = (sum * 10) + r;
            Debugger.log(sum);
            n = n / 10;
            Debugger.log(n);
        }
    }
}
