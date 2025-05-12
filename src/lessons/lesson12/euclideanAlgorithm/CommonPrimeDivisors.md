# 문제

A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P. For example, 2 and 5 are prime divisors of 20.

You are given two positive integers N and M. The goal is to check whether the sets of prime divisors of integers N and M are exactly the same.

For example, given:

* N = 15 and M = 75, the prime divisors are the same: {3, 5};
* N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
* N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.

Write a function:

    class Solution { public int solution(int[] A, int[] B); }

that, given two non-empty arrays A and B of Z integers, returns the number of positions K for which the prime divisors of A[K] and B[K] are exactly the same.

For example, given:

    A[0] = 15   B[0] = 75
    A[1] = 10   B[1] = 30
    A[2] = 3    B[2] = 5

the function should return 1, because only one pair (15, 75) has the same set of prime divisors.

Write an efficient algorithm for the following assumptions:

* Z is an integer within the range [1..6,000];
* each element of arrays A and B is an integer within the range [1..2,147,483,647].

# 정리

1. 두 수의 최대공약수(GCD) 를 구함 
2. 각 수를 GCD로 나눈 후, 그 결과가 1이 되는지 확인
3. 과정 반복 -> 모든 공통 소인수 제거

이 해결책의 작동 방식:
1.  두 수의 최대공약수를 구합니다
2.  각 수를 최대공약수로 나누어가며 모든 공통 소인수를 제거합니다
3.  만약 각 수가 1이 되면 모든 소인수가 공통이라는 의미입니다
4.  만약 각 수가 1이 되기 전에 최대공약수가 1이 되면, 다른 소인수가 있다는 의미입니다

예시:
* A[0] = 15, B[0] = 75
    * gcd(15, 75) = 15
    * 15/15 = 1, 75/15 = 5
    * 5와 15의 gcd = 5
    * 5/5 = 1
    * 모든 소인수가 공통이므로 true
* A[1] = 10, B[1] = 30
    * gcd(10, 30) = 10
    * 10/10 = 1, 30/10 = 3
    * 3과 10의 gcd = 1
    * 다른 소인수가 있으므로 false

```java
    public int solution(int[] A, int[] B) {
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];

            int gcd = gcd(a, b);

            if (hasSamePrimeDivisors(a, gcd) && hasSamePrimeDivisors(b, gcd)) {
                result++;
            }
        }

        return result;
    }

    private boolean hasSamePrimeDivisors(int a, int gcd) {
        while (a != 1) {
            int innerGcd = gcd(a, gcd);
            if (innerGcd == 1) {
                return false;
            }
            a /= innerGcd;
        }
        return true;
    }   
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
```