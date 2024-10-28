# 문제

An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

class Solution { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

# 풀이

##1.    시간 복잡도 O(K * N)

```java

    public int[] solution(int[] A, int K) {
    
    1.  K 번 회전시킨다.
            
        for (int i = 0; i < K; i++) {
            
    2.  각 회전에 대해 배열의 모든 요소를 한 칸씩 이동한다.
            
            for (int k = A.length-1; k > 0; k--) {
                int temp = A[k];
                A[k] = A[k - 1];
                A[k - 1] = temp;
            }
            
        }
    
        return A;
    }
    
```

시간 복잡도를 고려하지 않은 문제라 100%로 통과할 수 있었으나, 풀이 당시 깊게 고민하지 않은 흔적이 보인다.

## 2.   시간 복잡도 O(N)

```java

    public int[] solution(int[] A, int K) {
    
    1.  배열의 길이를 구한다.
        
            int N = A.length;
    
            if (N == 0) return A;
            
    2.  K가 N보다 큰 겨우, 실제 이동할 칸 수는 K%N으로 줄일 수 있다.
            
            K = K % N;
            
            int[] rotated = new int[N];
            
    3.  System.arraycopy 메서드 설명

            System.arraycopy(source, sourceStart, destination, destinationStart, length);
    
            - source: 복사할 원본 배열
            - sourceStart: 원본 배열에서 복사를 시작할 인덱스
            - destination: 복사할 대상 배열
            - destinationStart: 대상 배열에서 복사를 시작할 인덱스
            - length: 복사할 요소의 수
            
            System.arraycopy(A, N - K, rotated, 0, K);  // 오른쪽 끝 K개를 시작으로 복사
            System.arraycopy(A, 0, rotated, K, N - K);  // 나머지를 그 뒤에 복사
           
            
            return rotated;
    }
    
```

메모리를 효율적으로 직접 복사하기 때문에 수작업으로 복사하는 것보다 속도가 빠르다.