package lessons.lesson3.timeComplexity;

public class FrogJmp {

    public int solution(int X, int Y, int D) {
        int result = 0;

        // 캐스팅 형변환 필요. int -> double (소수점 계산)
        result = (int) Math.ceil((double)(Y - X) / D);

        return result;
    }

    public static void main(String[] args) {
        FrogJmp frogJmp = new FrogJmp();

        int X = 10;
        int Y = 85;
        int D = 30;

        int solution = frogJmp.solution(X, Y, D);
        System.out.println("solution = " + solution);
    }
}
