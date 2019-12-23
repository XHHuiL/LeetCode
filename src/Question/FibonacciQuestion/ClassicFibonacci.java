package Question.FibonacciQuestion;

public class ClassicFibonacci {

    public static int fibonacci(int n){
        // attention: implement by for loop
        if (n < 0)
            return -1;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int a1 = 0;
        int a2 = 1;
        int temp = 0;
        for (int i = 2; i <= n; i++){
            temp = a2;
            a2 = a1 + a2;
            a1 = temp;
        }
        return a2;
    }

}