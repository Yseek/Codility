package lessons.lesson12.euclideanAlgorithm;

public class CommonPrimeDivisors {

    public int solution(int[] A, int[] B) {
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            int b = B[i];

            int gcd = gcd(a, b);

            if (hasSamePrimeDivisors(a, gcd) && hasSamePrimeDivisors(b, gcd)) {
                result++;
            }
        }

        return result;
    }

    private boolean hasSamePrimeDivisors(int a, int gcd) {
        while (a != 1) {
            int innerGcd = gcd(a, gcd);
            if (innerGcd == 1) {
                return false;
            }
            a /= innerGcd;
        }
        return true;
    }   
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] A = {15, 10, 3};
        int[] B = {75, 30, 5};
        int result = new CommonPrimeDivisors().solution(A, B);
        System.out.println("result = " + result);
    }
}
