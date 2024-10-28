# 문제

A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].

# 풀이

```java

    public int solution(int N) {
    
    1.  N을 이진수로 변환한다. 
          
        String binary = Integer.toBinaryString(N);
    
    2.  변수 선언 
          
        int maxGap = 0;  // 가장 긴 이진 갭의 길이
        int currentGap = 0;  // 현재 이진 갭의 길이
        boolean inGap = false;  // 이진 갭을 찾기 시작했는지 여부
    
    3.  char형 배열로 변환 후 한 글자씩 비교
          
        for (char c : binary.toCharArray()) {
            
        3-1.    '1'일 경우 갭 카운트를 시작하거나 갭 카운트를 멈춰 maxGap의 값을 갱신한다.
          
            if (c == '1') {
                if (inGap) {  // 이진 갭이 끝난 경우
                    maxGap = Math.max(maxGap, currentGap);  // 최대 길이 갱신
                }
                // 1을 만나면 갭을 초기화하고 다시 시작
                inGap = true;
                currentGap = 0;
            } 
            
        3-2.    '0'일 경우 갭을 카운트한다.  
          
            else if (inGap) {  
                currentGap++;
            }
        }

        return maxGap;  // 가장 긴 이진 갭의 길이를 반환
    }   


```