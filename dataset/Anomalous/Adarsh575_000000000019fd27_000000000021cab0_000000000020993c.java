import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(sc.nextLine());

        for (int test = 1; test <= testCaseCount; test++) {
            int N = Integer.parseInt(sc.nextLine());
            int[][] square = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] row = sc.nextLine().split("\\s");
                for (int j = 0; j < N; j++) {
                    square[i][j] = Integer.parseInt(row[j]);
                }
            }

            int trace = calculateTrace(square);
            int duplicateRows = countDuplicateRows(square);
            int duplicateCols = countDuplicateCols(square);
            System.out.println("Case #" + test + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static int calculateTrace(int[][] square) {
        int trace = 0;
        for (int i = 0; i < square.length; i++) {
            trace += square[i][i];
        }
        return trace;
    }

    private static int countDuplicateRows(int[][] square) {
        int duplicateRowCount = 0;

        for (int[] row : square) {
            if (hasDuplicates(row)) {
                duplicateRowCount++;
            }
        }

        return duplicateRowCount;
    }

    private static int countDuplicateCols(int[][] square) {
        int duplicateColCount = 0;

        for (int col = 0; col < square.length; col++) {
            int[] column = new int[square.length];
            for (int row = 0; row < square.length; row++) {
                column[row] = square[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateColCount++;
            }
        }

        return duplicateColCount;
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }
}