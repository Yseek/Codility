package lessons.lesson6.sorting;

import java.util.Arrays;

public class NumberOfDiscIntersections {

    public int solution(int[] A) {
        int N = A.length;
        long[] start = new long[N];
        long[] end = new long[N];

        // 1. 시작점과 끝점 기록
        for (int i = 0; i < N; i++) {
            start[i] = (long) i - A[i];  // 왼쪽 끝점
            end[i] = (long) i + A[i];    // 오른쪽 끝점
        }

        // 2. 정렬
        Arrays.sort(start);
        Arrays.sort(end);

        // 3. 스위핑(Sweep Line) - 열린 원 개수를 세면서 교차 계산
        int intersections = 0;
        int openCircles = 0;
        int endIndex = 0;

        for (int i = 0; i < N; i++) {
            // 새 원의 시작점이 현재 열린 원들과 몇 개 겹치는지 확인
            while (endIndex < N && end[endIndex] < start[i]) {
                openCircles--;
                endIndex++;
            }

            intersections += openCircles; // 현재 열린 원들과 겹치는 개수 추가
            if (intersections > 10_000_000) return -1;

            openCircles++; // 현재 원 추가
        }

        return intersections;
    }

    public static void main(String[] args) {
        int[] A = {1, 5, 2, 1, 4, 0};

        NumberOfDiscIntersections numberOfDiscIntersections = new NumberOfDiscIntersections();
        int solution = numberOfDiscIntersections.solution(A);
        System.out.println("solution = " + solution);
    }
}