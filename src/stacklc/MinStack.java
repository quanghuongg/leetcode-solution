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
public class MinStack {
    /**
     * initialize your data structure here.
     */
    Stack<Node> stk;

    public MinStack() {
        stk = new Stack<>();
        stk.push(new Node(0, Integer.MAX_VALUE)); // dummy
    }

    public void push(int val) {
        int min = stk.peek().min;
        stk.push(new Node(val, Math.min(val, min)));
    }

    public void pop() {
        stk.pop();
    }

    public int top() {
        return stk.peek().val;
    }

    public int getMin() {
        return stk.peek().min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        System.out.println("m: " + minStack);
    }

    class Node {

        int val;
        int min;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}
