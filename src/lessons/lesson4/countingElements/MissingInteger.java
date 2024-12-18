package lessons.lesson4.countingElements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MissingInteger {

    public int solution(int[] A) {

        Set<Integer> positiveNumbers = Arrays.stream(A)
                .filter(x -> x > 0) // 양수의 정수만
                .collect(HashSet::new, HashSet::add, HashSet::addAll);

/**
 * 1 부터 Integer.MAX_VALUE 까지 positiveNumbers의 값과 비교한다.
 * 비교하는 수가 없을 경우 그 값을 반환
 */
        return IntStream.range(1, Integer.MAX_VALUE)
                .filter(x -> !positiveNumbers.contains(x))
                .findFirst()
                .getAsInt();

    }

    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();
//        int[] A = {1, 3, 6, 4, 1, 2};
        int[] A = {-1, -3};
//        int[] A = {1, 2, 3, 4};
        int solution = missingInteger.solution(A);
        System.out.println("solution = " + solution);
    }
}
