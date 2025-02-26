package lessons.lesson10.primeAndCompositeNumbers;

public class CountFactors {

    public int solution1(int N) {
        int i = 1;
        int result = 0;

        while (i <= N) {
            if (N % i == 0) {
                result++;
            }
            i++;
        }

        return result;
    }

    public int solution2(int N) {
        int result = 0;
        int sqrtN = (int) Math.sqrt(N);

        for (int i = 1; i <= sqrtN; i++) {
            if (N % i == 0) {
                result += 2;
                if (i == N / i) result--;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int N = 24;
        CountFactors countFactors = new CountFactors();

        int solution1 = countFactors.solution1(N);
        System.out.println("solution1 = " + solution1);

        int solution2 = countFactors.solution2(N);
        System.out.println("solution2 = " + solution2);
    }
}
