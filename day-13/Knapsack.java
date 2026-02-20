
public class Knapsack {

   static int knapsack(int W, int[] val, int[] wt) {

    int n = wt.length;
    int[][] dp = new int[n+1][W+1];

    for(int i=1;i<=n;i++){
        for(int j=1;j<=W;j++){

            if(wt[i-1] <= j)
                dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]],
                                    dp[i-1][j]);
            else
                dp[i][j] = dp[i-1][j];
        }
    }

    return dp[n][W];
}


    public static void main(String[] args) {

        int[] val = {1, 2, 3};
        int[] wt  = {1, 3, 4};
        int W = 4;

        System.out.println(knapsack(W, val, wt));
    }
}
