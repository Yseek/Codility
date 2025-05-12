# 문제

Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.

You start to eat the chocolates. After eating a chocolate you leave only a wrapper.

You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.

More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).

You stop eating when you encounter an empty wrapper.

For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.

The goal is to count the number of chocolates that you will eat, following the above rules.

Write a function:

    class Solution { public int solution(int N, int M); }

that, given two positive integers N and M, returns the number of chocolates that you will eat.

For example, given integers N = 10 and M = 4. the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

* N and M are integers within the range [1..1,000,000,000].

# 정리

* 시간 복잡도 O(N + M)

1. 길이 N의 boolean 배열을 만들어 도착한 곳을 true로 변경한다.
2. N 으로 나눈 나머지가 현재 인덱스

```java
    public int solution(int N, int M) {

        boolean[] chocolates = new boolean[N];

        int currentIndex = 0;
        int count = 0;

        while (!chocolates[currentIndex]) {
            chocolates[currentIndex] = true;
            currentIndex = (currentIndex + M) % N;
            count++;
        }

        return count;
    }
```

1. 패턴 관찰
* N = 10, M = 4일 때: 0 → 4 → 8 → 2 → 6 → 0
* N = 12, M = 4일 때: 0 → 4 → 8 → 0
* N = 12, M = 3일 때: 0 → 3 → 6 → 9 → 0
2. 패턴 비교
* N과 M의 최대공약수가 클수록 한 주기에 먹는 초콜릿의 개수가 적어짐
* N과 M의 최대공약수가 작을수록 한 주기에 먹는 초콜릿의 개수가 많아짐
3. 발견 규칙
* N을 최대공약수로 나누면 한 주기에 먹을 수 있는 초콜릿의 개수
* 이는 최대공약수가 클수록 같은 위치를 더 빨리 반복하게 되기 때문

```java
    public int solution(int N, int M) {
        return N / gcd(N, M);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
```