import java.util.Scanner;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        
        if (amount < 1) return 0;
        
        
        int[] minCoins = new int[amount + 1];
    
        for (int i = 1; i <= amount; i++) {
            minCoins[i] = Integer.MAX_VALUE;
        } 
       
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && minCoins[i - coin] != Integer.MAX_VALUE) {
                    minCoins[i] = Math.min(minCoins[i], minCoins[i - coin] + 1);
                }
            }
        }
       
       if (minCoins[amount] == Integer.MAX_VALUE) {
            return -1;   
        } else {
            return minCoins[amount]; 
        }

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of coin denominations: ");
        int n = scanner.nextInt();
        
        int[] coins = new int[n];
        System.out.println("Enter the coin denominations:");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the target amount: ");
        int amount = scanner.nextInt();
        
        CoinChange cc = new CoinChange();
        int result = cc.coinChange(coins, amount);
        
        if (result == -1) {
            System.out.println("It's not possible to make the amount with given coins.");
        } else {
            System.out.println("Minimum number of coins needed: " + result);
        }
        
        scanner.close();
    }
}