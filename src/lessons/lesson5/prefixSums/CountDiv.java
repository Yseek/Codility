package lessons.lesson5.prefixSums;

public class CountDiv {

    public int solution(int A, int B, int K) {
        // B까지 K로 나누어 떨어지는 수의 개수
        int countUpToB = B / K;
        System.out.println("countUpToB = " + countUpToB);
        // A가 0일 경우 0은 무엇으로 나눠도 나머지가 0 이기 때문에 횟수 1 을 추가한다.
        return (A > 0) ? countUpToB - (A - 1) / K : countUpToB + 1;
    }

    public static void main(String[] args) {
        CountDiv countDiv = new CountDiv();

        int A = 0;
        int B = 11;
        int K = 2;

        int solution = countDiv.solution(A, B, K);
        System.out.println("solution = " + solution);
    }
}
