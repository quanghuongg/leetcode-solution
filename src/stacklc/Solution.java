/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacklc;

import java.util.Stack;

/**
 *
 * @author huongnq2
 */
//Baseball Game
public class Solution {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String str : ops) {
            if (str.equals("C")) {
                stack.pop();
            } else if (str.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (str.equals("+")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                int temp3 = temp1 + temp2;
                stack.push(temp2);
                stack.push(temp1);
                stack.push(temp3);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        int total = 0;

        for (int s : stack) {
            total += s;
        }
        return total;
    }

    public static int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] < prices[i]) {
                    res[i] = prices[i] - prices[j];
                    break;
                } else {
                    res[i] = prices[i];
                }
            }
        }
        res[prices.length - 1] = prices[prices.length - 1];
        return res;
    }

    public static String simplifyPath(String path) {
        String[] strs = path.split("/");
        for (String str : strs) {
            System.out.println("str: " + str);
        }

        return "";
    }

    public static void main(String[] args) {
        String[] arr = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        int[] prices = {8, 4, 6, 2, 3};

        System.out.println(finalPrices(prices));
        simplifyPath("/../");

    }

}
