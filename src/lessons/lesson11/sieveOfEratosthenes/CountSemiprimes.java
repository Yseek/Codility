package lessons.lesson11.sieveOfEratosthenes;

import java.util.Arrays;

public class CountSemiprimes {

    public int[] solution(int N, int[] P, int[] Q) {

        boolean[] primes = new boolean[N + 1];
        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;

        // 1. 에라토스테네스의 체로 소수 판별
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (primes[i]) {
                for (int j = i * i; j <= N; j += i) {
                    primes[j] = false;
                }
            }
        }

        // 2. 세미프라임 여부 저장
        int[] semiPrimeCount = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            if (primes[i]) {
                for (int j = i; j * i <= N; j++) {
                    if (primes[j]) {
                        semiPrimeCount[i * j] = 1;
                    }
                }
            }
        }

        // 3. 누적 세미프라임 개수 저장
        for (int i = 1; i <= N; i++) {
            semiPrimeCount[i] += semiPrimeCount[i - 1];
        }

        int M = P.length;
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            result[i] = semiPrimeCount[Q[i]] - semiPrimeCount[P[i] - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 26;
        int[] P = {1, 4, 16};
        int[] Q = {26, 10, 20};

        int[] solution = new CountSemiprimes().solution(N, P, Q);
        System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
    }
}
