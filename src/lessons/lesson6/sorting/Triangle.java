package lessons.lesson6.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Triangle {

    public int solution(int[] A) {

        if (A.length <3) return 0;

        Arrays.sort(A);

        boolean exists = IntStream.range(0, A.length - 2)
                .anyMatch(i -> (long) A[i] + A[i + 1] > A[i + 2]);

        return exists ? 1 : 0;
    }

    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 20};

        Triangle triangle = new Triangle();
        int solution = triangle.solution(A);
        System.out.println("solution = " + solution);
    }
}
