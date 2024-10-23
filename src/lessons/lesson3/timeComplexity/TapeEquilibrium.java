package lessons.lesson3.timeComplexity;

import java.util.Arrays;

public class TapeEquilibrium {

    public int solution(int[] A) {

        /**
         * 왼쪽 배열의 합 ( 인덱스 0 부터 sum )
         * 오른쪽 배열의 합 ( 배열의 총합에서 인덱스 0 부터 뺴준다. )
         * 매 반복시 최소값을 구한다.
         */

        int leftSum = 0;
        int rightSum = Arrays.stream(A).sum();
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            int currentDifference = Math.abs(leftSum - rightSum);
            result = Math.min(result, currentDifference);
        }

        return result;
    }

    public static void main(String[] args) {
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        int[] A = {3, 1, 2, 4, 3};

        int solution = tapeEquilibrium.solution(A);
        System.out.println("solution = " + solution);
    }
}
