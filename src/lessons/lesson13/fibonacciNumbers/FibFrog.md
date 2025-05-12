# 문제

The Fibonacci sequence is defined using the following recursive formula:

    F(0) = 0
    F(1) = 1
    F(M) = F(M - 1) + F(M - 2) if M >= 2

A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.

The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:

* 0 represents a position without a leaf;
* 1 represents a position containing a leaf.

The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.

For example, consider array A such that:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0

The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.

Write a function:

    class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.

For example, given:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0

the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [0..100,000];
* each element of array A is an integer that can have one of the following values: 0, 1.

# 정리

1. 도달 가능한 피보나치 수 리스트 구하기
    - (N+1) 이하의 피보나치 수만 필요
2. BFS로 최소 점프 횟수 탐색
    - 시작점은 position -1 (강의 왼쪽 둑)
    - 도착점은 position N (강의 오른쪽 둑)
    - 이미 방문한 위치는 다시 방문하지 않음

    > BFS(Breadth-First Search, 너비 우선 탐색)는 그래프나 트리에서 "가장 가까운 것부터 차례대로" 탐색하는 알고리즘

```java
    public int solution(int[] A) {
        
        int N = A.length;
        List<Integer> fibs = new ArrayList<>();
        // 1. 피보나치 수 구하기 (N+1 이하)
        fibs.add(1);
        fibs.add(2);
        while (true) {
            int next = fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2);
            if (next > N + 1) break;
            fibs.add(next);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1]; // 0~N-1: 강, N: 오른쪽 둑
        queue.add(-1); // 시작점
        int jumps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            jumps++;
            for (int i = 0; i < size; i++) {
                int pos = queue.poll();
                for (int f = fibs.size() - 1; f >= 0; f--) {
                    int next = pos + fibs.get(f);
                    if (next == N) return jumps; // 도착!
                    if (next > N - 1 || next < 0) continue;
                    if (A[next] == 0 || visited[next]) continue;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return -1; // 도달 불가
    }
```