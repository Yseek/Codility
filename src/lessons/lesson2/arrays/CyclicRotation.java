package lessons.lesson2.arrays;

import java.util.Arrays;

public class CyclicRotation {

    public int[] solution(int[] A, int K) {

        for (int i = 0; i < K; i++) {
            for (int k = A.length-1; k > 0; k--) {
                int temp = A[k];
                A[k] = A[k - 1];
                A[k - 1] = temp;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;

        int[] result = cyclicRotation.solution(A, K);
        System.out.println("result = " + Arrays.toString(result));

        int[] B = {1, 2, 3, 4};
        int L = 4;

        int[] result2 = cyclicRotation.solution(B, L);
        System.out.println("result = " + Arrays.toString(result2));
    }
}
