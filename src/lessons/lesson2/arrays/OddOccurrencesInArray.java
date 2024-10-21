package lessons.lesson2.arrays;

import java.util.HashMap;

public class OddOccurrencesInArray {

    public int solution(int[] A) {
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
        }

        for (Integer integer : map.keySet()) {
            if (map.get(integer) % 2 == 1) {
                result = integer;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        int[] A = {9, 3, 9, 3, 9, 7, 9};

        int solution = oddOccurrencesInArray.solution(A);
        System.out.println("solution = " + solution);
    }
}
