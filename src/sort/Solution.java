/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.Map.Entry.comparingByValue;
import java.util.PriorityQueue;
import static java.util.stream.Collectors.toMap;

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

    int help(int x) {
        if (x == 1) {
            return 1;
        }
        int total = 0;
        while (x != 1) {
            if (x % 2 == 0) {
                x = x / 2;
                ++total;
            } else {
                x = 3 * x + 1;
                ++total;
            }
        }
        return total;
    }

    int find(Map<Integer, Integer> map) {
        int value = Integer.MAX_VALUE;
        int key = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < value) {
                key = entry.getKey();
                value = entry.getValue();
            } else if (entry.getValue() == value) {
                if (key > entry.getKey()) {
                    key = entry.getKey();
                }
            }
        }
        return key;
    }


    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lo; i <= hi; i++) {
            map.put(i, help(i));
        }
        int key = lo;
        while (k > 0) {
            key = find(map);
            map.remove(key);
            --k;
        }

        return key;
    }

    public int getKth2(int lo, int hi, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        for (int i = lo; i <= hi; i++) {
            int[] arr = new int[]{i, help(i)};
            queue.add(arr);
        }
        while (k > 1) {
            queue.poll();
            --k;
        }

        return queue.peek()[0];
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        for (int[] curr : people) {
            queue.add(curr);
        }

        List<int[]> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] person = queue.poll();
            result.add(person[1], person);
        }

        return result.toArray(new int[people.length][2]);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isPossibleDivide(new int[]{1, 1, 2, 2, 3, 3}, 2));
        System.out.println(solution.getKth2(144, 163, 5));
    }
}
