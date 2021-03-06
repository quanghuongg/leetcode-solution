/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author huongnq2
 */
public class Combination2 {

    public static int sum(int k) {
        int total = 0;
        for (int i = 1; i <= k; i++) {
            total += i;
        }
        return total;
    }

    public List<List<Integer>> combinationSum(int k, int target) {
        if (sum(k) > target || target > sum(9)) {
            return new ArrayList<>();
        }
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        findNumbers(k, ans, arr, target, 0, temp);
        return ans;
    }

    static void findNumbers(int k, List<List<Integer>> ans, List<Integer> arr, int sum, int index, List<Integer> temp) {
        if (sum == 0) {
            if (temp.size() == k) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            if ((sum - arr.get(i)) >= 0 && temp.size() < k) {
                temp.add(arr.get(i));
                findNumbers(k, ans, arr, sum - arr.get(i), i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    static int k = Integer.MAX_VALUE;
    public int numSquares(int sum) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(sum); i++) {
            arr.add(i * i);
        }
        List<Integer> temp = new ArrayList<>();
        findNumbersSquares(arr, sum, 0, temp);
        return k;
    }
    static void findNumbersSquares(List<Integer> arr, int sum, int index, List<Integer> temp) {
        if (sum == 0) {
            if (temp.size() < k) {
                k = temp.size();
            }
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            if ((sum - arr.get(i)) >= 0 && temp.size() < k) {
                temp.add(arr.get(i));
                findNumbersSquares(arr, sum - arr.get(i), i, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }



    static int sum(List<Integer> arr) {
        int total = 0;
        for (int i : arr) {
            total += i;
        }
        return total;
    }

    private int sum = 0;


    void findThreeSumClosest(List<Integer> arr, int target, int index, List<Integer> temp) {
        if (temp.size() == 3) {
            int total = sum(temp);
            if (Math.abs(total - target) <= sum || total - target == 0) {
                sum = total - target;
            }
            return;
        }
        for (int i = index; i < arr.size(); i++) {
            if (temp.size() < 3) {
                temp.add(arr.get(i));
                findThreeSumClosest(arr, target, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public int threeSumClosest(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        List<Integer> temp = new ArrayList<>();
        findThreeSumClosest(list, target, 0, temp);
        return sum + target;
    }


    public static void main(String[] args) {
        Combination2 combination2 = new Combination2();
        System.out.println(combination2.combinationSum(3, 7));
        System.out.println(combination2.numSquares(13));
        System.out.println("zz: " + combination2.threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1));
    }
}
