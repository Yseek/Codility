package lessons.lesson10.primeAndCompositeNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Peaks {
    
    public int solution(int[] A){
        int N = A.length;
        List<Integer> peaks = new ArrayList<>();

        // 1. 봉우리 찾기
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        if (peaks.isEmpty()) return 0;

        // 2. N의 약수 구하기 (큰 값부터 확인)
        List<Integer> divisors = new ArrayList<>();
        for (int K = 1; K <= Math.sqrt(N); K++) {
            if (N % K == 0) {
                divisors.add(K);
                if (K != N / K) {
                    divisors.add(N / K);
                }
            }
        }

        Collections.sort(divisors, Collections.reverseOrder());

        // 3. 블록 나누기 및 봉우리 포함 여부 검사
        for (int K : divisors) {
            int blockSize = N / K;
            boolean[] containsPeak = new boolean[K];

            for (int peak : peaks) {
                containsPeak[peak / blockSize] = true;
            }

            boolean valid = true;
            for( boolean hasPeak : containsPeak ) {
                if(!hasPeak) {
                    valid = false;
                    break;
                }
            }

            if (valid) return K;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        Peaks peaks = new Peaks();
        int solution = peaks.solution(A);
        System.out.println("solution = " + solution);
    }
}
