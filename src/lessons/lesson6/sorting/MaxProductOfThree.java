package lessons.lesson6.sorting;

import java.util.Arrays;

public class MaxProductOfThree {

    public int solution(int[] A) {

        int combinedMin = Arrays.stream(A).sorted()
                .limit(2)
                .reduce(1, (a, b) -> a * b)
                * Arrays.stream(A).sorted()
                .skip(A.length - 1)
                .findFirst()
                .getAsInt();

        int simpleMax = Arrays.stream(A).sorted()
                .skip(A.length - 3)
                .reduce(1, (a, b) -> a * b);

        return Math.max(combinedMin, simpleMax);
    }

    public static void main(String[] args) {
        MaxProductOfThree maxProductOfThree = new MaxProductOfThree();
//        int[] A = {-3, 1, 2, -2, 5, 6};
        int[] A = {-5, 5, -5, 4};
        int solution = maxProductOfThree.solution(A);
        System.out.println("solution = " + solution);
    }
}
