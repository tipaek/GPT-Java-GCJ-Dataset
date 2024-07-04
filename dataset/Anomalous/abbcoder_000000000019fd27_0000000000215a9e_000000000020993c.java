import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        ArrayList<int[][]> cases = readCases();

        for (int c = 0; c < cases.size(); c++) {
            int[][] data = cases.get(c);

            int N = data[0][0];
            int[][] matrix = Arrays.copyOfRange(data, 1, N + 1);

            int trace = calculateTrace(matrix, N);
            int rowRepeats = countRowRepeats(matrix, N);
            int columnRepeats = countColumnRepeats(matrix, N);

            System.out.printf("Case #%d: %d %d %d%n", c + 1, trace, rowRepeats, columnRepeats);
        }
    }

    static ArrayList<int[][]> readCases() {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        ArrayList<int[][]> cases = new ArrayList<>(T);

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] data = new int[N + 1][];
            data[0] = new int[] { N };
            for (int j = 1; j <= N; j++) {
                data[j] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            cases.add(data);
        }

        scanner.close();
        return cases;
    }

    static int calculateTrace(int[][] matrix, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    static int countRowRepeats(int[][] matrix, int N) {
        int repeats = 0;
        for (int i = 0; i < N; i++) {
            if (hasDuplicates(matrix[i])) {
                repeats++;
            }
        }
        return repeats;
    }

    static int countColumnRepeats(int[][] matrix, int N) {
        int repeats = 0;
        for (int j = 0; j < N; j++) {
            int[] column = new int[N];
            for (int i = 0; i < N; i++) {
                column[i] = matrix[i][j];
            }
            if (hasDuplicates(column)) {
                repeats++;
            }
        }
        return repeats;
    }

    static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (seen[value - 1]) {
                return true;
            }
            seen[value - 1] = true;
        }
        return false;
    }
}