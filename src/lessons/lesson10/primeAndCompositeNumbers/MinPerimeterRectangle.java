package lessons.lesson10.primeAndCompositeNumbers;

public class MinPerimeterRectangle {

    public int solution1(int N) {

        int result = Integer.MAX_VALUE;
        for (int A = 1; A <= Math.sqrt(N); A++) {
            if (N % A == 0) {
                int B = N / A;
                int perimeter = 2 * (A + B);
                result = Math.min(result, perimeter);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 5;

        MinPerimeterRectangle minPerimeterRectangle = new MinPerimeterRectangle();
        int solution1 = minPerimeterRectangle.solution1(N);
        System.out.println("solution1 = " + solution1);

    }
}
