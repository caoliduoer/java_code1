package practice;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public  int pop() {

        if(stack2.empty()){
            while(!stack1.empty()){
                Integer n=stack1.pop();
                stack2.push(n);
            }
            return stack2.pop();
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        MyQueue que=new MyQueue();
        que.push(2);

        que.push(3);
        que.push(99);
        System.out.println(0);
        que.pop();
        System.out.println(que.pop());

    }
}