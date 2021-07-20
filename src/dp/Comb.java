/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

/**
 *
 * @author huongnq2
 */
public class Comb {

    static int comb(int n, int k) {
        int C[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            C[i][0] = 1;
            C[i][i] = 1;
            for (int j = 1; j <= n; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
        return C[n][k];
    }

    public static void main(String[] args) {
        System.out.println("comb: " + comb(10, 5));
    }
}
