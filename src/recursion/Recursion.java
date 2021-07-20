/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author huongnq2
 */
public class Recursion {
    public static int countGoodNumbers(long n) {
        int total = 0;
        long size = (long) Math.pow(10, n);
        for (long i = 0; i < size; i++) {
            String temp = i + "";
            char[] chars = temp.toCharArray();
            boolean flag = true;
            for (int j = 0; j < chars.length; j++) {
                if (j % 2 == 0 && Integer.parseInt(chars[j] + "") % 2 == 1) {
                    flag = false;
                    break;
                }
                if (j % 2 == 1 && !isPrime(Integer.parseInt(chars[j] + ""))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                total += 1;
            }
        }
        return total;
    }

    private static boolean isPrime(int n) {
        if (n == 2 || n == 3 || n == 5 || n == 7)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));
    }
}
