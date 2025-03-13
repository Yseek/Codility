# 문제

A non-empty array A consisting of N integers is given.

A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].

For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2

has exactly four peaks: elements 1, 3, 5 and 10.

You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a figure below. You have to choose how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.

![Flags_1](../../../../images/img_Flags_1.png)

Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.

For example, given the mountain range represented by array A, above, with N = 12, if you take:

* two flags, you can set them on peaks 1 and 5;
* three flags, you can set them on peaks 1, 5 and 10;
* four flags, you can set only three flags, on peaks 1, 5 and 10.

You can therefore set a maximum of three flags in this case.

Write a function:

    class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.

For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2

the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..400,000];
* each element of array A is an integer within the range [0..1,000,000,000].

# 정리

1. 봉우리(peak) 찾기

   * A[P]가 __양 옆보다 클 때__(A[P-1] < A[P] > A[P+1]) -> Peak
   * 봉우리가 없으면 return 0
   * 예제에서 보면, peaks = [1, 3, 5, 10]
   * 시간 복잡도 O(N)
   

2. 깃발 배치

   * K 개의 깃발을 배치하면, __깃발 간의 거리는 K 이상__ 이어야 함.
   * 최대한 많은 깃발을 배치하는 K 값을 찾아야 함.
   * 시간 복잡도 O(N√N)
   

```java
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
```
