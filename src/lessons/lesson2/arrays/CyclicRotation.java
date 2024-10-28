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

    public int[] solution2(int[] A, int K) {
        int N = A.length;
        if (N == 0) return A;
        K = K % N;
        int[] rotated = new int[N];
        System.arraycopy(A, N - K, rotated, 0, K);  // 오른쪽 끝 K개를 시작으로 복사
        System.arraycopy(A, 0, rotated, K, N - K);  // 나머지를 그 뒤에 복사
        return rotated;
    }

    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;

        int[] result = cyclicRotation.solution(A, K);
        System.out.println("result = " + Arrays.toString(result));

        int[] B = {1, 2, 3, 4};
        int L = 4;

        int[] result2 = cyclicRotation.solution2(B, L);
        System.out.println("result = " + Arrays.toString(result2));
    }
}
