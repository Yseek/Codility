package lessons.lesson5.prefixSums;

import java.util.Arrays;

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;
        int[] result = new int[M];

        // Prefix sum arrays for A, C, G
        int[] prefixA = new int[N + 1];
        int[] prefixC = new int[N + 1];
        int[] prefixG = new int[N + 1];

        for (int i = 0; i < N; i++) {
            // Copy previous values
            prefixA[i + 1] = prefixA[i];
            prefixC[i + 1] = prefixC[i];
            prefixG[i + 1] = prefixG[i];

            // Update current nucleotide count
            char nucleotide = S.charAt(i);
            if (nucleotide == 'A') {
                prefixA[i + 1]++;
            } else if (nucleotide == 'C') {
                prefixC[i + 1]++;
            } else if (nucleotide == 'G') {
                prefixG[i + 1]++;
            }
        }

        // Process each query
        for (int k = 0; k < M; k++) {
            int start = P[k];
            int end = Q[k] + 1;  // +1 because prefix arrays are 1-indexed

            // Check presence of each nucleotide in range [start, end]
            if (prefixA[end] - prefixA[start] > 0) {
                System.out.println("k = " + k);
                System.out.println("end = " + end);
                System.out.println("prefixA end = " + prefixA[end]);
                System.out.println("start = " + start);
                System.out.println("prefixA start = " + prefixA[start]);
                result[k] = 1;  // 'A' found in range
            } else if (prefixC[end] - prefixC[start] > 0) {
                result[k] = 2;  // 'C' found in range
            } else if (prefixG[end] - prefixG[start] > 0) {
                result[k] = 3;  // 'G' found in range
            } else {
                result[k] = 4;  // Only 'T' remains
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
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
    }
}
