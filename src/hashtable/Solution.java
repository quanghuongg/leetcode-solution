/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author huongnq2
 */
public class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            }
        }
    }

    public int pick(int target) {
        if (map.containsKey(target)) {
            List<Integer> list = map.get(target);
            if (list.size() == 1) {
                return list.get(0);
            } else {
                Random random = new Random();
                int randomNumber = random.nextInt(list.size() + 1 - 1) + 1;
                return list.get(randomNumber - 1);
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution(new int[]{1, 2, 3, 3, 3});
        System.out.println(sol.pick(1));
    }
}
