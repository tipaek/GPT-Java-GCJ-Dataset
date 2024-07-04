import java.util.*;
import java.io.*;

public class Solution {
    private static int N;
    private static int K;
    private static int[][] matrix;
    private static int[] buffer;
    private static int delta;
    private static int swaps;
    private static int calcs;

    private static int calculateSwappedDiagonal(int src, int dst) {
        int k = 0;
        calcs++;
        for (int d = 0; d < N; d++) {
            int D = (d == src) ? dst : (d == dst ? src : d);
            k += matrix[D][d];
        }
        return Math.abs(K - k);
    }

    private static boolean swapRows(int src, int dst) {
        int newDelta = calculateSwappedDiagonal(src, dst);
        if (newDelta < delta) {
            swaps++;
            System.arraycopy(matrix[src], 0, buffer, 0, buffer.length);
            System.arraycopy(matrix[dst], 0, matrix[src], 0, buffer.length);
            System.arraycopy(buffer, 0, matrix[dst], 0, buffer.length);
            delta = newDelta;
            return true;
        }
        return false;
    }

    private static boolean optimizeMatrix() {
        boolean newSolution = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && swapRows(i, j)) {
                    newSolution = true;
                }
            }
        }
        return newSolution;
    }

    private static void processCase(Scanner in, int caseNumber) {
        N = in.nextInt();
        K = in.nextInt();
        swaps = 0;
        calcs = 0;
        matrix = new int[N][N];
        buffer = new int[N];
        boolean isPossible = false;

        int start = N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (start > N) start -= N;
                matrix[i][j] = start++;
            }
            start--;
        }

        StringBuilder row = new StringBuilder();

        delta = 0;
        for (int d = 0; d < N; d++) {
            delta += matrix[d][d];
        }
        delta = Math.abs(K - delta);

        if (delta == 0) {
            isPossible = true;
        } else {
            while (optimizeMatrix()) ;
            if (delta == 0) {
                isPossible = true;
            }
        }

        System.out.println("Case #" + caseNumber + ": " + (isPossible ? "POSSIBLE" : "IMPOSSIBLE"));

        if (isPossible) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    row.append(matrix[i][j]).append(' ');
                }
                System.out.println(row.toString());
                row.setLength(0);
            }
        }
    }

    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream(new File("test.in"));
            System.setIn(inputStream);
        } catch (Throwable ignored) {
        }

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            processCase(scanner, i);
        }
    }
}