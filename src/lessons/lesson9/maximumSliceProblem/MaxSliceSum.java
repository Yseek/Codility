package lessons.lesson9.maximumSliceProblem;

public class MaxSliceSum {

    public int solution1(int[] A) {
        int maxSum = A[0];

        for (int i = 0; i < A.length; i++) {
            int tempSum = A[i];
            maxSum = Math.max(maxSum, tempSum);
            for (int j = i + 1; j < A.length; j++) {
                tempSum += A[j];
                maxSum = Math.max(maxSum, tempSum);
            }
        }

        return maxSum;
    }


    public int solution2(int[] A) {
        int maxSum = A[0];
        int currentSum = A[0];

        for (int i = 1; i < A.length; i++) {
            currentSum = Math.max(A[i], currentSum + A[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, -6, 4, 0};

        int solution1 = new MaxSliceSum().solution1(A);
        System.out.println("solution1 = " + solution1);
        int solution2 = new MaxSliceSum().solution2(A);
        System.out.println("solution2 = " + solution2);
    }
}
