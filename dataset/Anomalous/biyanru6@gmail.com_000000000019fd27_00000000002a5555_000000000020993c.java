import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int diagonalSum = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasRepeat = false;
                for (int col = 0; col < n; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;

                    if (row == col) {
                        diagonalSum += value;
                    }

                    if (!rowHasRepeat && rowSet.contains(value)) {
                        rowRepeats++;
                        rowHasRepeat = true;
                    } else {
                        rowSet.add(value);
                    }
                }
            }

            for (int col = 0; col < n; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean colHasRepeat = false;
                for (int row = 0; row < n; row++) {
                    int value = matrix[row][col];
                    if (!colHasRepeat && colSet.contains(value)) {
                        colRepeats++;
                        colHasRepeat = true;
                    } else {
                        colSet.add(value);
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
    }
}