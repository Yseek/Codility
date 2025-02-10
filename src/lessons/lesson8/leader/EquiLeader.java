package lessons.lesson8.leader;

public class EquiLeader {

    public int solution(int[] A) {
        int N = A.length;
        if (N == 1) return 0;

        // 1. 리더 찾기 (Boyer-Moore Majority Vote Algorithm)
        int candidate = A[0], count = 0;
        for (int num : A) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // 2. candidate가 실제 리더인지 확인
        int leader = -1, leaderCount = 0;
        for (int num : A) {
            if (num == candidate) leaderCount++;
        }
        if (leaderCount > N / 2) leader = candidate;
        else return 0;  // 리더가 없으면 equi leader도 없음.

        // 3. equi leader 개수 찾기
        int leftCount = 0, equiLeaders = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == leader) leftCount++;

            int leftSize = i + 1;
            int rightCount = leaderCount - leftCount;
            int rightSize = N - leftSize;

            if (leftCount > leftSize / 2 && rightCount > rightSize / 2) {
                equiLeaders++;
            }
        }

        return equiLeaders;
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 4, 4, 4, 2};
        EquiLeader equiLeader = new EquiLeader();
        int solution = equiLeader.solution(A);
        System.out.println("solution = " + solution);
    }
}
