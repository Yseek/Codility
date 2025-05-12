package lessons.lesson13.fibonacciNumbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FibFrog {
    
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

    public static void main(String[] args) {
        int[] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
        int result = new FibFrog().solution(A);
        System.out.println("result = " + result);
    }
}
