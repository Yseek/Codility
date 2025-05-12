package lessons.lesson12.euclideanAlgorithm;

public class ChocolatesByNumbers {

    public int solution(int N, int M) {
        return N / gcd(N, M);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int N = 10;
        int M = 4;
        int solution = new ChocolatesByNumbers().solution(N, M);
        System.out.println("solution = " + solution);
    }
}
