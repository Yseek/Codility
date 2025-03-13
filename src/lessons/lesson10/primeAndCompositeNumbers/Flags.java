package lessons.lesson10.primeAndCompositeNumbers;

public class Flags {

    public int solution(int[] A) {
        int N = A.length;
        if (N < 3) return 0; // 봉우리를 만들 최소 개수(3개) 미만이면 0 반환

        /*
         * 봉우리 찾기:
         * A[i]가 A[i-1], A[i+1]보다 크면 봉우리(peak)
         * 봉우리 위치를 기록하여 깃발을 배치할 수 있도록 준비
         */
        boolean[] peaks = new boolean[N];
        int peakCount = 0;
        for (int i = 1; i < N - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[i] = true;
                peakCount++;
            }
        }
        /*
         * A: [1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2]
         * peaks: [false, true, false, true, false, true, false, false, false, false, true, false]
         * peakCount: 4
         */
        if (peakCount == 0) return 0; // 봉우리 없음

        /*
         * 최대 깃발 개수 찾기:
         * 깃발을 1개부터 peakCount 개수만큼 배치해보고 가능한 최대값 찾기
         */
        int maxFlags = 0;
        for (int flags = 1; flags <= peakCount; flags++) {  // 배치할 깃발 개수 증가
            int usedFlags = 0;  // 현재 배치한 깃발 개수
            int lastFlag = -flags;  // 마지막 깃발을 배치한 위치 (초기값: -flags로 설정)

            for (int i = 0; i < N; i++) {
                if (peaks[i] && i >= lastFlag + flags) {
                    usedFlags++;
                    lastFlag = i;
                    if (usedFlags == flags) {
                        break;
                    }
                }
            }

            maxFlags = Math.max(maxFlags, usedFlags);   // 최대 배치 가능 개수 업데이트

            if (usedFlags < flags) {
                break;  // 더 이상 깃발을 늘릴 수 없으면 종료
            }
        }

        return maxFlags;
    }


    public static void main(String[] args) {
        int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        Flags flags = new Flags();
        int solution = flags.solution(A);
        System.out.println("solution = " + solution);
    }
}
