package lessons.lesson7.stacksAndQueues;

import java.util.Stack;

public class Fish {

    public int solution(int[] A, int[] B) {

        Stack<Integer> down = new Stack<>();
        int alive = 0; // 살아남은 물고기 개수

        for (int i = 0; i < A.length; i++) {

            if (B[i] == 1) {
                // downstream 물고기는 스택에 추가
                down.push(A[i]);
            } else {
                // upstream 물고기와 downstream 물고기 비교
                while (!down.isEmpty()) {
                    // upstream 물고기가 잡아먹힘
                    if (down.peek() > A[i]) {
                        break;
                    } else {
                        // upstream 물고기가 더 크면 downstream 물고기를 제거
                        down.pop();
                    }
                }
            }

            // 싸울 상대가 없으면 살아남음
            if (down.isEmpty()) {
                alive++;
            }
        }

        // 남아있는 downstream 물고기들도 살아남음
        return alive + down.size();
    }

    public static void main(String[] args) {

        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};

        Fish fish = new Fish();
        int solution = fish.solution(A, B);
        System.out.println("solution = " + solution);

    }
}
