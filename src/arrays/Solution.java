/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        for (int i = 0; i < people.length; i++)        {
            for (int j = 0; j < people[i].length; j++) {
                System.out.print(people[i][j] + " ");
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
