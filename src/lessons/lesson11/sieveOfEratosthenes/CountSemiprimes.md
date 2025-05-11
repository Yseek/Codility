# 문제

A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.

Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

For example, consider an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20

The number of semiprimes within each of these ranges is as follows:

* (1, 26) is 10,
* (4, 10) is 4,
* (16, 20) is 0.

Write a function:

    class Solution { public int[] solution(int N, int[] P, int[] Q); }

that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.

For example, given an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20

the function should return the values [10, 4, 0], as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..50,000];
* M is an integer within the range [1..30,000];
* each element of arrays P and Q is an integer within the range [1..N];
* P[i] ≤ Q[i].

# 정리

* 시간 복잡도 O(N * log(log(N)) + M * N) or O(M * N**3) or O(M * N ** (3/2)) -> TIMEOUT ERROR (괴랄한 시간복잡도...)

1. 배열 초기화 → isPrime[N+1]을 true로 설정하여 모든 숫자를 소수로 가정
2. 소수가 아닌 숫자 제거 → 2부터 √N까지 반복하며 소수의 배수 제거

```java
    public int[] solution(int N, int[] P, int[] Q) {

        boolean[] primes = new boolean[N + 1];
        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (primes[i]) {
                for (int j = i * i; j <= N; j += i) {
                    primes[j] = false;
                }
            }
        }

        Set<Integer> semiPrimes = new HashSet<>();
        for (int i = 2; i <= N; i++) {
            for(int j = 2; j <= N; j++) {
                if (primes[i] && primes[j]) {
                    int semi = i * j;
                    if (semi <= N) {
                        semiPrimes.add(semi);
                    }
                }
            }
        }

        int[] result = new int[P.length];

        for (int i =0; i < P.length; i++) {
            int start = P[i];
            int end = Q[i];

            int count = (int) IntStream.rangeClosed(start, end)
                    .filter(semiPrimes::contains)
                    .count();

            result[i] = count;
        }

        return result;
    }
```

효율성을 어떻게 올려야 할지... 일단 패쓰
