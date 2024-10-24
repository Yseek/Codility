package lessons.lesson4.countingElements;

import java.util.Arrays;

public class PermCheck {

    public int solution(int[] A) {
        int N = A.length;

        // 배열에 중복된 숫자가 있으면 0 반환
        boolean hasDuplicates = Arrays.stream(A)
                                        .distinct()
                                        .count() != N;
        if (hasDuplicates) {
            return 0;
        }

        // 1부터 N까지의 숫자가 모두 있는지 확인
        boolean vaildRange = Arrays.stream(A)
                .allMatch(i -> i >= 1 && i <= N);

        if (!vaildRange) {
            return 0;
        }

        // 순열이면 1 반환
        return 1;
    }

    public static void main(String[] args) {
        PermCheck permCheck = new PermCheck();
        int[] A = {4, 3, 2};
        int solution = permCheck.solution(A);
        System.out.println("solution = " + solution);
    }
}
