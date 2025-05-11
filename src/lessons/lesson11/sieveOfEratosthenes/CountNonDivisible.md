# 문제

You are given an array A consisting of N integers.

For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.

For example, consider integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6

For the following elements:

* A[0] = 3, the non-divisors are: 2, 6,
* A[1] = 1, the non-divisors are: 3, 2, 3, 6,
* A[2] = 2, the non-divisors are: 3, 3, 6,
* A[3] = 3, the non-divisors are: 2, 6,
* A[4] = 6, there aren't any non-divisors.

Write a function:

    class Solution { public int[] solution(int[] A); }

that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
the function should return [2, 4, 3, 2, 0], as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..50,000];
* each element of array A is an integer within the range [1..2 * N].

# 정리

* 시간 복잡도 O(N ** 2) -> TIMEOUT ERROR

```java
    public int[] solution(int[] A) {

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            int count = 0;

            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    if (A[i] % A[j] != 0) {
                        count++;
                    }
                }
            }

            result[i] = count;
        }

        return result;
    }
```

* 약수의 개수를 구한 뒤, 약수를 제외한 개수를 구한다.
* Map 이 필요하다.

```java
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
```

