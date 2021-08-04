/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.util.Arrays;

/**
 *
 * @author huongnq2
 */
public class Solution {
    //https://leetcode.com/problems/predict-the-winner/
   public boolean PredictTheWinner(int[] nums) {

       int[] dp = Arrays.copyOf(nums, nums.length);

       for (int len = 2; len <= nums.length; len++) {
           for (int i = 0; i + len - 1 < nums.length; i++) {
               dp[i] = Math.max(nums[i] - dp[i + 1], nums[i + len - 1] - dp[i]);
           }
       }

       return dp[0] >= 0;

    }

    int helper(int[] nums, int start, int end, Integer[][] dp) {
        if (dp[start][end] == null) {
            dp[start][end] = (start == end) ? nums[start]
                    : Math.max(nums[start] - helper(nums, start + 1, end, dp), nums[end] - helper(nums, start, end - 1, dp));
        }
        return dp[start][end];
    }
}
