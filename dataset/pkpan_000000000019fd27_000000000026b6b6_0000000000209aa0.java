import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tc = 1 ; tc <= tests ; tc++) {

            int n = scanner.nextInt();
            int requiredTrace = scanner.nextInt();

            int[][] latinMatrix = construct(n);

            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            rearrange(n, latinMatrix, requiredTrace);

            if (getTrace(n, latinMatrix) == requiredTrace) {
                System.out.println("Case #" + tc + ": POSSIBLE" );
                print(latinMatrix);
            } else {
                System.out.println("Case #" + tc + ": IMPOSSIBLE" );
            }
        }

        scanner.close();
    }

    private static void rearrange(int n, int[][] latinMatrix, int requiredTrace) {
        int trace = getTrace(n, latinMatrix);

        if (trace == requiredTrace) {
            return;
        }

        for (int i = 0 ; i < n-1 ; i++) {
            for (int j = i+1 ; j < n ; j++) {
                int delta = diffIfSwapRow(latinMatrix, i, j);

                if (shouldSwap(requiredTrace, trace, delta)) {
                    swapRows(latinMatrix, i, j);
                    trace = getTrace(n, latinMatrix);
                }
            }
        }
    }

    private static boolean shouldSwap(int requiredTrace, int trace, int delta) {
        if (delta == 0)
            return false;

        int newTrace = trace + delta;
        int newDelta = requiredTrace - newTrace;
        int oldDelta = requiredTrace - trace;

        return newDelta == 0 || (Math.abs(newDelta) < Math.abs(oldDelta) && Math.signum(newDelta) == Math.signum(oldDelta));
    }

    private static void swapRows(int[][] latinMatrix, int i, int j) {
        int[] temp = latinMatrix[i];
        latinMatrix[i] = latinMatrix[j];
        latinMatrix[j] = temp;
    }

    private static int getTrace(int n, int[][] latinMatrix) {
        int trace = 0;
        for (int i = 0 ; i < n ; i++) {
            trace += latinMatrix[i][i];
        }

        return trace;
    }

    private static int diffIfSwapRow(int[][] latinMatrix, int rowX, int rowY) {
        int delta1 = latinMatrix[rowX][rowY] - latinMatrix[rowY][rowY];
        int delta2 = latinMatrix[rowY][rowX] - latinMatrix[rowX][rowX];

        return delta1 + delta2;
    }

    private static void print(int[][] sudoku) {
        for (int[] row : sudoku) {
            for (int cell : row)
                System.out.print(cell+" ");
            System.out.println("");
        }
    }

    private static int[][] construct(int n) {
        int[][] latinMatrix = new int[n][n];

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                latinMatrix[i][j] = ((i+j) % n)+1;
            }
        }

        return latinMatrix;
    }
}

