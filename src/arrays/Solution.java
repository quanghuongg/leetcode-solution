/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author huongnq2
 */
public class Solution {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (k >= arr.length) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> values = new ArrayList<Integer>(map.values());
        Collections.sort(values);
        int count = 0;
        for (int i : values) {
            ++count;
            k = k - i;
            if (k == 0) {
                return map.size() - count;
            } else if (k < 0) {
                return map.size() - count + 1;
            }
        }
        return -1;
    }

    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people[i].length; j++) {
                System.out.print(people[i][j] + " ");
            }
        }
        return res;
    }

//    https://leetcode.com/problems/split-array-largest-sum/
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();

        int low = max;
        int high = sum;

        while (low < high) {
            int mid = low + (high - low) / 2;
            System.out.println("mid: " + mid);

            int maxPart = maxSumOfPart(nums, m, mid);
            System.out.println("maxPart: " + maxPart);

            if (maxPart == -1) {
                low = mid + 1;
            } else {
                high = Math.max(low, maxPart);
            }
        }

        return low;
    }

    private int maxSumOfPart(int[] nums, int m, int maxSumPerPart) {
        int n = nums.length;
        int parts = 0;
        int currSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            if (currSum + nums[i] > maxSumPerPart) {
                parts++;
                maxSum = Math.max(maxSum, currSum);
                currSum = 0;
            }
            currSum += nums[i];
        }
        parts++;
        maxSum = Math.max(maxSum, currSum);
        System.out.println("maxSum: " + maxSum);

        return parts <= m ? maxSum : -1;
    }

//    https://leetcode.com/problems/partition-equal-subset-sum/
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum >> 1;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    int num = nums[i - 1];
                    if (dp[i - 1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        if (j - num >= 0 && dp[i - 1][j - num] == true) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }

        return dp[n][target];

    }

    static void findNumbers(List<Integer> ans, int[] arr, int sum, int index, List<Integer> temp) {
        if (sum == 0) {
            // Adding deep copy of list to ans
            ans.add(1);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if ((sum - arr[i]) >= 0) {
                temp.add(arr[i]);

                findNumbers(ans, arr, sum - arr[i], i + 1,
                        temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public void foo(int n) {
        if (n <= 1) {
            return;
        }
        System.out.println("n: " + n);
        foo(n - 1);
        foo(n - 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.foo(5);
//        sol.splitArray(new int[]{7, 2, 5, 10, 8}, 2);
//        System.out.println(sol.canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}));;
    }
}
