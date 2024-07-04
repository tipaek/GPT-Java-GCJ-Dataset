import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 0; i < cases; i++) {
            int size = input.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;
            int repeatedCols = 0;
            int repeatedRows = 0;

            // Reading matrix input
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    matrix[r][c] = input.nextInt();
                }
            }

            // Calculating trace
            for (int r = 0; r < size; r++) {
                trace += matrix[r][r];
            }

            // Checking for repeated elements in columns
            for (int c = 0; c < size; c++) {
                Set<Integer> columnElements = new HashSet<>();
                for (int r = 0; r < size; r++) {
                    if (!columnElements.add(matrix[r][c])) {
                        repeatedCols++;
                        break;
                    }
                }
            }

            // Checking for repeated elements in rows
            for (int r = 0; r < size; r++) {
                Set<Integer> rowElements = new HashSet<>();
                for (int c = 0; c < size; c++) {
                    if (!rowElements.add(matrix[r][c])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Displaying output
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
    }
}