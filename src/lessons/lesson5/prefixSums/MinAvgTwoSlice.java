package lessons.lesson5.prefixSums;

public class MinAvgTwoSlice {

    public int solution(int[] A) {
        int startingPosition = 0;
        double minValue = Double.MAX_VALUE;

        int length = A.length;

        for (int i = 0; i < length - 1; i++) {
            double avg2 = (A[i] + A[i + 1]) / 2.0;
            if (avg2 < minValue) {
                minValue = avg2;
                startingPosition = i;
            }

            if (i < length - 2) {
                double avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                if (avg3 < minValue) {
                    minValue = avg3;
                    startingPosition = i;
                }
            }
        }

        return startingPosition;
    }

    public static void main(String[] args) {
        MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

        int[] A = {4, 2, 2, 5, 1, 5, 8};
        int solution = minAvgTwoSlice.solution(A);
        System.out.println("solution = " + solution);
    }
}
