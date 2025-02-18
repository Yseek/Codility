package lessons.lesson9.maximumSliceProblem;

public class MaxProfit {

    public int solution1(int[] A) {
        int max = -1;

        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int profit = A[j] - A[i];
                if (profit > 0) {
                    max = Math.max(profit, max);
                }
            }
        }

        return max > -1 ? max : 0;
    }

    public int solution2(int[] A) {
        if (A.length == 0) return 0;

        int minPrice = A[0];
        int maxProfit = 0;

        for (int i = 1; i < A.length; i++) {
            maxProfit = Math.max(maxProfit, A[i] - minPrice);
            minPrice = Math.min(minPrice, A[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
        MaxProfit maxProfit = new MaxProfit();
        int solution1 = maxProfit.solution1(A);
        System.out.println("solution1 = " + solution1);

        int solution2 = maxProfit.solution2(A);
        System.out.println("solution2 = " + solution2);
    }
}
