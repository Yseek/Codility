package lessons.lesson9.maximumSliceProblem;

public class MaxDoubleSliceSum {

    public int solution1(int[] A) {
        int N = A.length;

        int[] leftSum = new int[N];
        int[] rightSum = new int[N];

        for (int i = 1; i < N - 1; i++) {
            leftSum[i] = Math.max(0, leftSum[i - 1] + A[i]);
        }

        for (int i = N - 2; i > 0; i--) {
            rightSum[i] = Math.max(0, rightSum[i + 1] + A[i]);
        }

        int maxSum = 0;
        for (int Y = 1; Y < N - 1; Y++) {
            maxSum = Math.max(maxSum, leftSum[Y - 1] + rightSum[Y + 1]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 6, -1, 4, 5, -1, 2};
        int solution1 = new MaxDoubleSliceSum().solution1(A);
        System.out.println("solution1 = " + solution1);
    }
}
