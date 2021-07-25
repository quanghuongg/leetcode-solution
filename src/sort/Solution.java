/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author huongnq2
 */
public class Solution {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        for (int i = 0; i < costs.length; i++) {
            coins = coins - costs[i];
            if (coins >= 0) {
                if (i == costs.length - 1) {
                    return costs.length;
                }
            } else {
                return i + 1 - 1;
            }
        }
        return -1;

    }

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>(nums.length);
        for (int id : nums) {
            list.add(id);
        }
        while (true) {
            int first = list.get(0);
            for (int i = 0; i < k; i++) {
                if (list.contains(i + first)) {
                    list.remove(list.indexOf(i + first));
                } else {
                    return false;
                }
            }
            Collections.sort(list);
            if (list.isEmpty()) {
                break;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPossibleDivide(new int[]{1, 1, 2, 2, 3, 3}, 2));
    }
}
