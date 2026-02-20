
public class Matrixchain {

    static void matrixChain(int[] p) {
        int n = p.length;
        int[][] m = new int[n][n];   // cost matrix
        int[][] s = new int[n][n];   // split matrix
        // d = chain length difference
        for (int d = 1; d < n-1; d++) {
            for (int i = 1; i < n-d; i++) {
                int j = i + d;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k]
                          + m[k+1][j]
                          + p[i-1]*p[k]*p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;   // store split
                    }
                }
            }
        }

        System.out.println("Minimum cost = " + m[1][n-1]);
    }

    public static void main(String[] args) {

        int[] p = {5,4,6,2,7};   // same as your image

        matrixChain(p);
    }
}
