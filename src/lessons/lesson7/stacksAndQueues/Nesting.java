package lessons.lesson7.stacksAndQueues;

import java.util.Stack;

public class Nesting {

    public int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if ('(' == c) {
                stack.push(c);
            } else if (')' == c) {
                if (stack.isEmpty()) {
                    return 0;
                }
                stack.pop();
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {

        String S = "())";
        Nesting nesting = new Nesting();
        int solution = nesting.solution(S);
        System.out.println("solution = " + solution);
    }
}
