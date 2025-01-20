package lessons.lesson6.sorting;

import java.util.Arrays;

public class Distinct {

    public int solution(int[] A) {
        return Arrays.stream(A).distinct().toArray().length;
    }

    public static void main(String[] args) {
        Distinct distinct = new Distinct();

        int[] A = {2, 1, 1, 2, 3, 1};
        int solution = distinct.solution(A);
    }
}
