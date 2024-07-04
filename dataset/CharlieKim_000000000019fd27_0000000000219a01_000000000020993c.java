import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numOfCases = scanner.nextInt();

        for (int i = 0; i < numOfCases; i++) {
            int n = scanner.nextInt();
            int[][] square = getSquare(scanner, n);

            System.out.println("Case #" + (i + 1) + ": " + solve(square, n));
        }
    }

    private static int[][] getSquare(Scanner scanner, int n) {
        int[][] square = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                square[i][j] = scanner.nextInt();
            }
        }

        return square;
    }

    private static String solve(int[][] square, int n) {
        int trace = 0;
        int numOfDiffCol = 0;
        int numOfDiffRow = 0;
        for (int i = 0; i < n; i++) {
            trace += square[i][i];

            int[] row = new int[n];
            for (int j = 0; j < n; j++) {
                row[j] = square[i][j];
            }
            if (!isLatinMatrix(row)) {
                numOfDiffRow += 1;
            }

            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = square[j][i];
            }
            if (!isLatinMatrix(col)) {
                numOfDiffCol += 1;
            }
        }

        return trace + " " + numOfDiffRow + " " + numOfDiffCol;
    }

    private static boolean isLatinMatrix(int[] line) {
        Set<Integer> set = new HashSet<>();
        for (int value : line) {
            set.add(value);
        }

        return line.length == set.size();
    }
}