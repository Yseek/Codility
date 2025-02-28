# 문제

An integer N is given, representing the area of some rectangle.

The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

For example, given integer N = 30, rectangles of area 30 are:

* (1, 30), with a perimeter of 62,
* (2, 15), with a perimeter of 34,
* (3, 10), with a perimeter of 26,
* (5, 6), with a perimeter of 22.

Write a function:

    class Solution { public int solution(int N); }

that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

For example, given an integer N = 30, the function should return 22, as explained above.

Write an efficient algorithm for the following assumptions:

* N is an integer within the range [1..1,000,000,000].

# 정리

### 초기 풀이

```java
    public int solution1(int N) {

        int result = Integer.MAX_VALUE;
        for (int A = 1; A <= Math.sqrt(N); A++) {
            if (N % A == 0) {
                int B = N / A;
                int perimeter = 2 * (A + B);
                result = Math.min(result, perimeter);
            }
        }
        return result;
    }
```

![MinPerimeterRectangle_1](../../../../images/img_MinPerimeterRectangle_1.png)

오랜만에 초기 풀이로 100%가 나왔다.

---

### 최종 풀이

1. 완전 탐색이 아닌 약수 기반 탐색

* 어떤 두 정수 A, B의 곱이 N이 되는 경우를 찾아야 한다.
* 만약 A가 N의 약수라면, B는 B = N / A가 된다.
* 따라서 A * B = N을 만족하는 (A, B)를 찾으면 된다.


2. 탐색 범위를 줄이기

* A의 최대 범위를 sqrt(N)까지로 제한할 수 있다.
* 이유: 약수 (A, B)를 찾을 때, 작은 A부터 시작하면 그에 대응하는 B = N / A는 항상 크거나 같다.
* 따라서 A가 sqrt(N)을 넘어가면 B는 이미 확인된 값이므로 중복 탐색이 발생한다.
