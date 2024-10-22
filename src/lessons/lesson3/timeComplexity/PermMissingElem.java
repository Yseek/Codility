package lessons.lesson3.timeComplexity;

import java.util.Arrays;

public class PermMissingElem {

    public int solution(int[] A) {
        int result = 0;

        int expectedSum  = (1 + A.length) * (2 + A.length) / 2;

        int sum = Arrays.stream(A).sum();

        result = expectedSum - sum;

        return result;
    }

    public static void main(String[] args) {
        PermMissingElem permMissingElem = new PermMissingElem();

        int[] A = {2, 3, 1, 5, 6, 7, 8, 9, 10, 11, 13, 4};

        int solution = permMissingElem.solution(A);

        System.out.println("solution = " + solution);
    }
}
