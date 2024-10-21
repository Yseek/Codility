package lessons.lesson1.iterations;

public class BinaryGap {

    public int solution(int N) {
        int result = 0;

        String binary = Integer.toBinaryString(N);

        char[] chars = binary.toCharArray();

        int temp = 0;

        for (char aChar : chars) {
            if (aChar == '0') {
                temp++;
            }

            if (aChar == '1') {
                if (temp > result) {
                    result = temp;
                    temp = 0;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        int gaps = binaryGap.solution(9);

        System.out.println("gaps = " + gaps);
    }
}
