package com.wintherdev.datastructures.stack;

public class Main {
    public static void main(String[] args) {


        Stack<Integer> stack = new Stack<>();

        System.out.println(stack.isEmpty());

        stack.push(1);
        stack.push(5);
        stack.push(10);


        System.out.println(stack.toString());

        int number = stack.pop();

        System.out.println(stack.toString());

        System.out.println(stack.isEmpty());

        System.out.println(stack.peek());

        System.out.println(stack.search(5));
    }
}
