import java.util.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if (T < 1 || T > 100) {
            System.out.println("1 <= T <= 100");
            return;
        }

        List<String> finalOutput = new ArrayList<>();

        for (int n = 1; n <= T; n++) {
            int N = sc.nextInt();
            if (N < 2 || N > 100) {
                System.out.println("2 <= N <= 100");
                return;
            }

            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int value = sc.nextInt();
                    if (value > N) {
                        System.out.println("Input should be in the range of Matrix size N");
                        return;
                    }
                    matrix[i][j] = value;
                }
            }

            int trace = calculateTrace(matrix, N);
            int rowsWithRepeats = countRowsWithRepeatedElements(matrix, N);
            int colsWithRepeats = countColumnsWithRepeatedElements(matrix, N);

            finalOutput.add("Case #" + n + ": " + trace + " " + rowsWithRepeats + " " + colsWithRepeats);
        }

        for (String output : finalOutput) {
            System.out.println(output);
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowsWithRepeatedElements(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!seen.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int countColumnsWithRepeatedElements(int[][] matrix, int size) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> seen = new HashSet<>();
            for (int i = 0; i < size; i++) {
                if (!seen.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}