package lessons.lesson4.countingElements;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class FrogRiverOne {

    public int solution(int X, int[] A) {
        // 나뭇잎이 떨어진 위치들을 저장할 Set
        Set<Integer> leaves = new HashSet<>();

        // stream을 이용해 배열을 순회
        return IntStream.range(0, A.length)
                .filter(i -> {
                    // 위치가 X 이하일 때만 처리
                    if (A[i] <= X) {
                        leaves.add(A[i]);  // 나뭇잎이 떨어진 위치를 Set에 추가
                    }
                    System.out.println("leaves = " + leaves);
                    System.out.println("leaves.size() = " + leaves.size());
                    // 모든 위치에 나뭇잎이 다 떨어졌으면 시간을 반환
                    return leaves.size() == X;
                })
                .findFirst()  // 가장 빠른 시간 반환
                .orElse(-1);  // 만약 모든 위치에 나뭇잎이 다 떨어지지 않았다면 -1 반환
    }

    public static void main(String[] args) {
        FrogRiverOne frogRiverOne = new FrogRiverOne();

        int X = 5;
        int[] A = {1, 3, 5, 1, 2, 3, 5, 4};

        int solution = frogRiverOne.solution(X, A);
        System.out.println("solution = " + solution);
    }
}
