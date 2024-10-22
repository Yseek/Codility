package lessons.lesson1.iterations;

public class BinaryGap {

    public int solution(int N) {
        String binary = Integer.toBinaryString(N); // N을 이진수 문자열로 변환
        int maxGap = 0;  // 가장 긴 이진 갭의 길이
        int currentGap = 0;  // 현재 이진 갭의 길이
        boolean inGap = false;  // 이진 갭을 찾기 시작했는지 여부

        for (char c : binary.toCharArray()) {
            if (c == '1') {
                if (inGap) {  // 이진 갭이 끝난 경우
                    maxGap = Math.max(maxGap, currentGap);  // 최대 길이 갱신
                }
                // 1을 만나면 갭을 초기화하고 다시 시작
                inGap = true;
                currentGap = 0;
            } else if (inGap) {  // 갭이 시작된 상태에서 0을 카운트
                currentGap++;
            }
        }

        return maxGap;  // 가장 긴 이진 갭의 길이를 반환
    }

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        int gaps = binaryGap.solution(9);

        System.out.println("gaps = " + gaps);
    }
}
