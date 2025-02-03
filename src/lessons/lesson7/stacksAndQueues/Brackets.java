package lessons.lesson7.stacksAndQueues;

import java.util.Stack;

public class Brackets {

    public int solution(String S) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // 열린 괄호는 스택에 넣는다
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;

                // 닫힌 괄호가 나오면 스택에서 꺼내 짝을 맞춘다
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return 0;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return 0;
                    }
                    break;

                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return 0;
                    }
                    break;
            }
        }

        // 스택이 비어 있으면 올바르게 중첩된 괄호, 아니면 잘못된 괄호가 있음
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {

        Brackets brackets = new Brackets();
        String S = "{[()()]}";
//        String S = "([)()]";
        int solution = brackets.solution(S);
        System.out.println("solution = " + solution);

    }
}
