package lessons.lesson4.countingElements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    public int solution(int[] A) {

        Set<Integer> positiveNumbers = Arrays.stream(A)
                .filter(x -> x > 0) // 양수의 정수만
                .collect(HashSet::new, HashSet::add, HashSet::addAll);

        // 1 부터 있는지 Set에 있는 데이터와 비교
        for (int i = 1; i <= A.length + 1; i++) {
            if (!positiveNumbers.contains(i)) {
                return i; // 1부터 시작해서 가장 수가 작을 때 Set에 없을 경우 return
            }
        }

        // ex)  [1, 2, 3, 4] 일 경우 5 return
        return A.length + 1;

    }

    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();
//        int[] A = {1, 3, 6, 4, 1, 2};
//        int[] A = {-1, -3};
        int[] A = {1, 2, 3, 4};
        int solution = missingInteger.solution(A);
        System.out.println("solution = " + solution);
    }
}
