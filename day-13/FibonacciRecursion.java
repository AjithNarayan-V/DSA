import java.util.Scanner;

public class FibonacciRecursion {
    static int[] dp = new int[100]; // Memoization array
    static int fib(int n) {
        if (n <= 1)
            return n;
        if (dp[n] != 0)
            return dp[n];
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int result = fib(n);
        System.out.println("Fibonacci of " + n + " is: " + result);
        
        sc.close();
    }
}