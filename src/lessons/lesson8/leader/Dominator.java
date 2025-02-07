package lessons.lesson8.leader;


import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Dominator {

    public int solution(int[] A) {
        int N = A.length;
        if (N == 0) return -1;

        Map<Integer, Long> frequencyMap = Arrays.stream(A)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Optional<Map.Entry<Integer, Long>> dominatorEntry = frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if (dominatorEntry.get().getValue() <= N/2) return -1;

        int dominator = dominatorEntry.get().getKey();

        return IntStream.range(0, N)
                .filter(i -> A[i] == dominator)
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        Dominator dominator = new Dominator();
        int solution = dominator.solution(A);
        System.out.println("solution = " + solution);
    }
}
