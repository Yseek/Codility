package lessons.lesson5.prefixSums;

import java.util.Arrays;

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;

        // Prefix sum 배열 초기화
        int[] A = new int[N + 1];
        int[] C = new int[N + 1];
        int[] G = new int[N + 1];

        for (int i = 0; i < N; i++) {
            A[i + 1] = A[i];
            C[i + 1] = C[i];
            G[i + 1] = G[i];

            char nucleotide = S.charAt(i);
            if (nucleotide == 'A') {
                A[i + 1]++;
            } else if (nucleotide == 'C') {
                C[i + 1]++;
            } else if (nucleotide == 'G') {
                G[i + 1]++;
            }
        }
        System.out.println("A = " + Arrays.toString(A));
        System.out.println("C = " + Arrays.toString(C));
        System.out.println("G = " + Arrays.toString(G));

        // 쿼리 처리
        int[] result = new int[M];
        for (int k = 0; k < M; k++) {
            int start = P[k];
            int end = Q[k] + 1; // Prefix sum이므로 end + 1
            
            if (A[end] - A[start] > 0) {
                result[k] = 1;  // A 존재
            } else if (C[end] - C[start] > 0) {
                result[k] = 2;  // C 존재
            } else if (G[end] - G[start] > 0) {
                result[k] = 3;  // G 존재
            } else {
                result[k] = 4;  // T 존재
            }
        }

        return result;

    }

    public static void main(String[] args) {
        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] solution = genomicRangeQuery.solution(S, P, Q);
    }
}
