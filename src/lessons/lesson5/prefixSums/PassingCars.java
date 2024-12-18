package lessons.lesson5.prefixSums;

public class PassingCars {

    public int solution(int[] A) {
        int eastCount = 0;
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                result += eastCount;
            } else {
                eastCount++;
            }

            if (result > 1000000000) {
                return -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PassingCars passingCars = new PassingCars();
        int[] A = {0, 1, 0, 1, 1};
        int solution = passingCars.solution(A);

        System.out.println("solution = " + solution);
    }
}
