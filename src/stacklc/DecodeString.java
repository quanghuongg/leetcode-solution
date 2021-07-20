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
public class DecodeString {

    public static String decode2(String str) {
        String res = "";
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        int index = 0;
        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index))) {
                int count = 0;
                while (Character.isDigit(str.charAt(index))) {
                    count = 10 * count + (str.charAt(index) - '0');
                    index += 1;
                }
                counts.push(count);
            } else if (str.charAt(index) == '(') {
                result.push(res);
                res = "";
                index += 1;
            } else if (str.charAt(index) == ')') {
                StringBuilder stringBuilder = new StringBuilder(result.pop());
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    stringBuilder.append(res);
                }
                res = stringBuilder.toString();
                index += 1;
            } else {
                res += str.charAt(index);
                index += 1;
            }
        }
        return res;
    }

    public int minAddToMakeValid(String s) {
        int count = 0;
        Stack<String> result = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                result.push(s.charAt(i) + "");
            } else {
                if (result.size() > 0) {
                    result.pop();
                } else {
                    ++count;
                }
            }
        }
        return result.size() + count;
    }

    public static int calculate(String s) {
        s = s.trim();
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                str += s.charAt(i);
            }
        }
        str = str.trim();
        int index = 0;
        Stack<Integer> counts = new Stack<>();
        Stack<Character> sign = new Stack<>();
        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index))) {
                int count = 0;
                while (index < str.length() && Character.isDigit(str.charAt(index))) {
                    count = 10 * count + (str.charAt(index) - '0');
                    index += 1;
                }
                System.out.println("index: " + index);
                counts.push(count);
            } else if (str.charAt(index) == '+' || str.charAt(index) == '-') {
                sign.push(str.charAt(index));
                index += 1;
                System.out.println("index: " + index);

            } else if (str.charAt(index) == '*') {
                int temp = counts.pop();
                index++;
                int count = 0;
                while (index < str.length() && Character.isDigit(str.charAt(index))) {
                    count = 10 * count + (str.charAt(index) - '0');
                    index += 1;
                }
                counts.push(temp * count);
                System.out.println("index: " + index);

            } else if (str.charAt(index) == '/') {
                int temp = counts.pop();
                index++;
                int count = 0;
                while (index < str.length() && Character.isDigit(str.charAt(index))) {
                    count = 10 * count + (str.charAt(index) - '0');
                    index += 1;
                }
                counts.push(temp / count);
                System.out.println("index: " + index);
            } else {
                index++;
            }

        }

        int total = counts.get(0);
        for (int i = 0; i < sign.size(); i++) {
            Character temp = sign.get(i);
            if (temp.equals('+')) {
                total += counts.get(i + 1);
            } else {
                total -= counts.get(i + 1);
            }
        }
        return total;

    }

    public static String decode(String str) {
        String res = "";
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        int index = 0;
        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index))) {
                int count = 0;
                while (Character.isDigit(str.charAt(index))) {
                    count = 10 * count + (str.charAt(index) - '0');
                    index += 1;
                }
                counts.push(count);
            } else if (str.charAt(index) == '(') {
                result.push(res);
                res = "";
                index += 1;
            } else if (str.charAt(index) == ')') {
                int count = counts.pop();
                StringBuilder builder = new StringBuilder(result.pop());
                for (int i = 0; i < count; i++) {
                    builder.append(res);
                }
                res = builder.toString();
                index += 1;
            } else {
                res += str.charAt(index);
                index += 1;
            }
        }
        return res;
    }

    public static void hello(int count) {
        count++;

        if (count <= 5) {
            System.out.println("helloL " + count);
            hello(count);
        }
    }

    public static void main(String[] args) {
//        System.out.println(decode("a2(b2(c2(d2(e))))"));
//        System.out.println(decode2("a2(b2(c2(d2(e))))"));
        System.out.println("huongnq: " + calculate("3+5 / 2"));
    }
}
