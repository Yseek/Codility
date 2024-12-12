package lessons.lesson3.timeComplexity;

import java.util.Arrays;

public class PermMissingElem {

    public int solution(int[] A) {
        int result = 0;

        int N = A.length + 1;

        long expectedSum = (long) N * (N + 1) / 2;

        long sum = Arrays.stream(A).sum();

        result = (int) (expectedSum - sum);

        return result;
    }

    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();

        int[] A = {2, 3, 1, 5, 6, 7, 8, 9, 10, 11, 13, 4};

        int solution = permMissingElem.solution(A);

        System.out.println("solution = " + solution);
    }
}
