package lessons.lesson11.sieveOfEratosthenes;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CountNonDivisible {

    public int[] solution(int[] A) {

        int N = A.length;

        // 1. 숫자 횟수 기록
        Map<Integer, Long> countMap = Arrays.stream(A)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        // 2. 약수 개수 계산
        Map<Integer, Integer> divisrosMap = countMap.keySet().stream()
                .collect(Collectors.toMap(n -> n, n -> {
                    int divisors = 0;
                    for (int i = 1; i <= Math.sqrt(n); i++) {
                        if (n % i == 0) {
                            divisors += countMap.getOrDefault(i, 0L);
                            if (i != n / i) {
                                divisors += countMap.getOrDefault(n / i, 0L);
                            }
                        }
                    }
                    return divisors;
                }));

        // 3. 약수 제외 개수 계산
        return Arrays.stream(A)
                .map(n -> N - divisrosMap.get(n))
                .toArray();
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 3, 6};
        int[] solution = new CountNonDivisible().solution(A);
        System.out.println("solution = " + Arrays.toString(solution));
    }
}
