import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private static final boolean DEBUG = false;
    private static int N;
    private static int[][] matrix;

    private static void solveProblem(InputStream inputStream) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        int testCount = scanner.nextInt();
        for (int t = 1; t <= testCount; t++) {
            N = scanner.nextInt();
            matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                matrix[i] = readIntegers(scanner, N);
            }
            String result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String solveTestCase() {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
            if (hasDuplicates(matrix[i])) {
                rowDuplicates++;
            }
            if (hasDuplicates(getColumn(matrix, i))) {
                colDuplicates++;
            }
        }
        return trace + " " + rowDuplicates + " " + colDuplicates;
    }

    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[N + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int columnIndex) {
        int[] column = new int[N];
        for (int i = 0; i < N; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }

    private static int[] readIntegers(Scanner scanner, int count) {
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printDebug(Object message) {
        if (DEBUG) {
            System.out.println("DEBUG: " + message);
        }
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        if (DEBUG) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - startTime));
        } else {
            solveProblem(System.in);
        }
    }
}