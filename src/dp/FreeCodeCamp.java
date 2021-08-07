/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author huongnq2
 */
public class FreeCodeCamp {

    public int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }


    public int fibonacciMemoization(int n) {
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n - 1];
    }

    public int gridTraveler(int m, int n) {
        if (n == 1 && m == 1) {
            return 1;
        }
        if (n == 0 | m == 0) {
            return 0;
        }
        return gridTraveler(m - 1, n) + gridTraveler(m, n - 1);
    }

    public Long dinamicTravelMemo(int m, int n) {
        return dinamicTravelMemo(m, n, new HashMap<>());
    }

    private Long dinamicTravelMemo(int m, int n, HashMap<String, Long> memo) {
        if (m == 0 || n == 0) {
            return Long.valueOf(0);
        }
        if (m == 1 && n == 1) {
            return Long.valueOf(1);
        }
        String key = m > n ? n + "-" + m : m + "-" + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        Long value = dinamicTravelMemo(m - 1, n, memo) + dinamicTravelMemo(m, n - 1, memo);
        memo.put(key, value);
        return value;
    }

    public long gridTravelerMemoization(int m, int n, Map<String, Long> mem) {
        if (n == 1 && m == 1) {
            return 1l;
        }
        if (n == 0 || m == 0) {
            return 0l;
        }
        if (mem.containsKey(buildKey(m, n))) {
            return mem.get(buildKey(m, n));
        }
        mem.put(buildKey(m, n), gridTravelerMemoization(m - 1, n, mem) + gridTravelerMemoization(m, n - 1, mem));
        return mem.get(buildKey(m, n));
    }

    String buildKey(int m, int n) {
        return m + "," + n;
    }

    public static void main(String[] args) {
        FreeCodeCamp sol = new FreeCodeCamp();

//        fibonacci
        System.out.println(sol.fibonacciMemoization(45));
//        System.out.println(sol.fibonacci(45));

//        gridTraveler
//        System.out.println(sol.gridTraveler(18, 18));

        System.out.println(sol.gridTravelerMemoization(18, 18, new HashMap<>()));


    }


}
