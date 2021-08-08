/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }

    private int climbStairs(int n, HashMap<Integer, Integer> memo) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int value = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        memo.put(n, value);
        return value;
    }

    int buy(int[] a, int i, int[] dp1, int[] dp2) {
        if (i == dp1.length) {
            return 0;
        }
        if (dp1[i] != 0) {
            return dp1[i];
        }
        return dp1[i] = Math.max(-a[i] + sell(a, i + 1, dp1, dp2), buy(a, i + 1, dp1, dp2));
    }

    int sell(int[] a, int i, int[] dp1, int[] dp2) {
        if (i == dp2.length) {
            return 0;
        }
        if (dp2[i] != 0) {
            return dp2[i];
        }
        return dp2[i] = Math.max(a[i] + buy(a, i + 1, dp1, dp2), sell(a, i + 1, dp1, dp2));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        return buy(prices, 0, dp1, dp2);
    }


    String buildKey(int m, int n) {
        return m + "," + n;
    }

    public List<Integer> bestSumMemoization(int targetSum, int[] nums) {
        return bestSumMemoization(targetSum, nums, new HashMap<>());
    }

    public List<Integer> bestSumMemoization(int targetSum, int[] nums, HashMap<Integer, List<Integer>> mem) {
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        List<Integer> shortestCom = null;
        if (mem.containsKey(targetSum)) {
            return mem.get(targetSum);
        }
        for (int num : nums) {
            int remainder = targetSum - num;
            List<Integer> remainderCom = bestSumMemoization(remainder, nums, mem);
            if (remainderCom != null) {
                List<Integer> com = new ArrayList<>();
                com.addAll(remainderCom);
                com.add(num);
                if (shortestCom == null || com.size() < shortestCom.size()) {
                    shortestCom = com;
                }
            }
        }
        mem.put(targetSum, shortestCom);
        return shortestCom;
    }

    public boolean canSumMemoization(int targetSum, int[] nums) {
        return canSumMemoization(targetSum, nums, new HashMap<>());
    }

    public boolean canSumMemoization(int targetSum, int[] nums, HashMap<Integer, Boolean> mem) {
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        if (mem.containsKey(targetSum)) {
            return mem.get(targetSum);
        }
        for (int num : nums) {
            int remainder = targetSum - num;
            if (canSumMemoization(remainder, nums, mem) == true) {
                mem.put(targetSum, Boolean.TRUE);
                return true;
            }
        }
        mem.put(targetSum, Boolean.FALSE);
        return false;
    }

    public boolean canSum(int targetSum, int[] nums) {
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (int num : nums) {
            int remainder = targetSum - num;
            if (canSum(remainder, nums) == true) {
                return true;
            }
        }
        return false;
    }

    public boolean canConstruct(String target, String[] nums) {
        return canConstruct(target, nums, new HashMap<>());
    }

    public boolean canConstruct(String target, String[] words, HashMap<String, Boolean> mem) {
        if (target.isEmpty()) {
            return true;
        }
        if (mem.containsKey(target)) {
            return mem.get(target);
        }
        for (String word : words) {
            if (target.indexOf(word) == 0) {
                String temp = target.substring(word.length());
                if (canConstruct(temp, words, mem)) {
                    mem.put(target, Boolean.TRUE);
                    return true;
                }
            }
        }
        mem.put(target, Boolean.FALSE);
        return false;
    }


    public static void main(String[] args) {
        FreeCodeCamp sol = new FreeCodeCamp();

//        fibonacci
//        System.out.println(sol.fibonacciMemoization(45));
//        System.out.println(sol.fibonacci(45));

//        gridTraveler
//        System.out.println(sol.gridTraveler(18, 18));
//        System.out.println(sol.gridTravelerMemoization(18, 18, new HashMap<>()));
//        canSum
//        System.out.println(sol.canSum(300, new int[]{7, 14}));
        System.out.println(sol.canSumMemoization(300, new int[]{7, 14}));

        System.out.println(sol.climbStairs(5));
        System.out.println(sol.bestSumMemoization(100, new int[]{1, 2, 25, 14}));
        System.out.println(sol.canConstruct("huongnq", new String[]{"huo", "n", "nq", "12321321"}));


    }


}
