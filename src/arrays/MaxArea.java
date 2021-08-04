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

/**
 *
 * @author huongnq2
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int res = -1;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = Math.min(height[i], height[j]);
                int area = temp * (j - i);
                if (area > res) {
                    res = area;
                }
            }
        }
        return res;
    }

    public static int maxArea2(int[] height) {
        int i = 0, j = height.length - 1;
        int min = Integer.MIN_VALUE, ans = Integer.MIN_VALUE;
        while (i < j) {
            min = Math.min(height[i], height[j]) * (j - i);

            ans = Math.max(ans, min);

            if (height[i] < height[j]) {
                while (i < j && height[i] > height[i + 1]) {
                    i++;
                }
                i++;
            } else {
                while (i < j && height[j] > height[j - 1]) {
                    j--;
                }
                j--;
            }
        }

        return ans;
    }

    public static int g(String s) {
        int k = 0, m = 26;
        for (int i = 0; i < s.length(); i++) {
            k += (int) s.charAt(i) + i * (int) s.charAt(i);
        }
        return (k % m);
    }

    public static long compute_hash(String s) {
        int p = 31;
        int m = (int) (Math.pow(10, 9) + 9);
        long hash_value = 0;
        long p_pow = 1;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            hash_value = (hash_value + (c - 'a' + 1) * p_pow) % m;
            p_pow = (p_pow * p) % m;
        }
        return hash_value;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        if (strs.length == 1) {
            res.add(Arrays.asList(strs[0]));
            return res;
        }

        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String newStr = new String(arr);
            if (hashMap.containsKey(newStr)) {
                hashMap.get(newStr).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                hashMap.put(newStr, strList);
            }

        }

        return new ArrayList<>(hashMap.values());

    }

    private List<Integer> push(List<Integer> list, int n, int num) {
        for (int i = 0; i < num; i++) {
            list.add(n);
        }
        return list;
    }

    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        findNumbers(ans, arr, target, 0, temp);
        return ans;
    }

    static void findNumbers(List<List<Integer>> ans, int[] arr, int sum, int index, List<Integer> temp) {
        if (sum == 0) {
            // Adding deep copy of list to ans
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            // checking that sum does not become negative
            if ((sum - arr[i]) >= 0) {

                // adding element which can contribute to
                // sum
                temp.add(arr[i]);

                findNumbers(ans, arr, sum - arr[i], i,
                        temp);

                // removing element from list (backtracking)
                temp.remove(temp.size() - 1);
            }
        }
    }

    static boolean isoMorphic(String str1,
            String str2) {
        int CHAR = 256;

        int n = str1.length();
        int m = str2.length();

        // Length of both strings must be
        // same for one to one
        // correspondence
        if (n != m) {
            return false;
        }

        // For counting the previous appearances
        // of character in both the strings
        int[] countChars1 = new int[CHAR];
        int[] countChars2 = new int[CHAR];

        // Process all characters one by one
        for (int i = 0; i < n; i++) {
            System.out.println(str1.charAt(i));
            System.out.println(str2.charAt(i));

            System.out.println(countChars1[str1.charAt(i)]++);
            System.out.println(countChars2[str2.charAt(i)]++);

            // For string to be isomorphic the
            // previous counts of appearances of
            // current character in both string
            // must be same if it is not same we
            // return false.
            if (countChars1[str1.charAt(i)]
                    != countChars2[str2.charAt(i)]) {
                return false;
            }
        }
        return true;
    }
    int sum = 0;

    public int subsetXORSum(int[] nums) {
        findSubset(nums, 0, nums.length, 0);
        return sum;
    }

    public void findSubset(int[] a, int s, int e, int cxor) {
        if (s == e) {
            sum = sum + cxor;
            return;
        }

        findSubset(a, s + 1, e, cxor ^ a[s]);
        findSubset(a, s + 1, e, cxor);
    }

    public boolean checkPossibility(int[] nums) {
        boolean flag = true;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
            }
            if (count > 1) {
                flag = false;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                nums[i + 1] = nums[i] - 1;
                count++;
            }
            if (count > 1) {
                flag = false;
            }
        }

        return true;
    }

    static String intToString(List<Integer> intArray) {
        String res = "";
        for (int i = 0; i < intArray.size(); i++) {
            res += String.valueOf(intArray.get(i));
        }
        return res;
    }

    static int binarySearch(int[] nums, int lo, int hi, int x) {

        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;

        if (nums[mid] > x) {
            return binarySearch(nums, lo, mid - 1, x);
        } else if (nums[mid] < x) {
            return binarySearch(nums, mid + 1, hi, x);
        } else {
            return mid;
        }
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                int val = -nums[i] - nums[j];
                int find = binarySearch(nums, j + 1, size - 1, val);
                if (find > 0) {
                    if (res.size() > 0 && nums[i] == res.get(res.size() - 1).get(0) && nums[j] == res.get(res.size() - 1).get(1)) {
                        continue;
                    } else {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], val);
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        maxArea2(new int[]{2, 1, 4, 6});
//        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
//        System.out.println(compute_hash("eat"));
//        System.out.println(compute_hash("tea"));
//        System.out.println(compute_hash("ate"));
//        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));

//        System.out.println(isoMorphic("bbbaaaba", "aaabbbba") ? 1 : 0);

        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

    }

}
