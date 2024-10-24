package lessons.lesson4.countingElements;

import java.util.Arrays;

public class MaxCounters {

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N]; // N개의 카운터 배열
        int maxCounter = 0;          // 현재 최대 카운터 값
        int lastMaxUpdate = 0;       // 마지막 max counter 연산 시의 값

        // 배열 A의 각 연산을 처리
        for (int i = 0; i < A.length; i++) {
            int operation = A[i];

            if (operation >= 1 && operation <= N) {
                // increase(X) 연산: 카운터를 1 증가
                if (counters[operation - 1] < lastMaxUpdate) {
                    // 이전 max counter 연산이 적용되지 않은 경우 값을 갱신
                    counters[operation - 1] = lastMaxUpdate;
                }
                counters[operation - 1]++;

                // 최대 카운터 값 갱신
                if (counters[operation - 1] > maxCounter) {
                    maxCounter = counters[operation - 1];
                }
            } else if (operation == N + 1) {
                // max counter 연산: 모든 카운터를 현재 최대 값으로 설정
                lastMaxUpdate = maxCounter;
            }
        }

        // 마지막 max counter 연산이 적용되지 않은 카운터들을 업데이트
        for (int i = 0; i < N; i++) {
            if (counters[i] < lastMaxUpdate) {
                counters[i] = lastMaxUpdate;
            }
        }

        return counters;
    }

    public static void main(String[] args) {
        MaxCounters maxCounters = new MaxCounters();
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int[] solution = maxCounters.solution(N, A);
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
    }
}