package lessons.lesson7.stacksAndQueues;

import java.util.Stack;

public class StoneWall {

    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int blocks = 0;

        for (int height : H) {
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
            }

            if (stack.isEmpty() || stack.peek() < height) {
                stack.push(height);
                blocks++;
            }
        }

        return blocks;
    }

    public static void main(String[] args) {
        int[] H = {8, 8, 5, 7, 9, 8, 7, 4, 8};

        StoneWall stoneWall = new StoneWall();
        int solution = stoneWall.solution(H);
        System.out.println("solution = " + solution);
    }
}
