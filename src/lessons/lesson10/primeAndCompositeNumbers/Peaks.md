# 문제

A non-empty array A consisting of N integers is given.

A peak is an array element which is larger than its neighbors. More precisely, it is an index P such that 0 < P < N − 1,  A[P − 1] < A[P] and A[P] > A[P + 1].

For example, the following array A:

    A[0] = 1
    A[1] = 2
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

has exactly three peaks: 3, 5, 10.

We want to divide this array into blocks containing the same number of elements. More precisely, we want to choose a number K that will yield the following blocks:

* A[0], A[1], ..., A[K − 1],
* A[K], A[K + 1], ..., A[2K − 1], ...
* A[N − K], A[N − K + 1], ..., A[N − 1].

What's more, every block should contain at least one peak. Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be peaks, but only if they have both neighbors (including one in an adjacent blocks).

The goal is to find the maximum number of blocks into which the array A can be divided.

Array A can be divided into blocks as follows:

* one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.
* two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
* three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak. Notice in particular that the first block (1, 2, 3, 4) has a peak at A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.

However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2), because the (1, 2, 3) blocks do not contain a peak. Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and A[5].

The maximum number of blocks that array A can be divided into is three.

Write a function:

    class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the maximum number of blocks into which A can be divided.

If A cannot be divided into some number of blocks, the function should return 0.

For example, given:

    A[0] = 1
    A[1] = 2
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

* N is an integer within the range [1..100,000];
* each element of array A is an integer within the range [0..1,000,000,000].

# 정리

* N의 약수를 구해서 내림 차순으로 정렬 후, 블록 사이즈를 이용해 containsPeak[K] 이 모두 true 인지 확인한다.
* peaks 인덱스를 blockSize = 4 로 나누면 :
   * peak 3  →  3 / 4 = 0   (블록 0)
   * peak 5  →  5 / 4 = 1   (블록 1)
   * peak 10 →  10 / 4 = 2  (블록 2)
   * 즉, 모든 블록에 최소 하나의 봉우리가 포함됨!

```java
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
```
