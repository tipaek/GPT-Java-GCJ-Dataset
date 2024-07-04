import java.util.*;
import java.io.*;

public class Vestigium {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("test.in"));
        int cases = input.nextInt();

        for (int i = 0; i < cases; i++) {
            int size = input.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;
            int repeatedRows = 0;
            int repeatedCols = 0;

            // Read matrix input
            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    matrix[r][c] = input.nextInt();
                }
            }

            // Calculate trace
            for (int r = 0; r < size; r++) {
                trace += matrix[r][r];
            }

            // Calculate repeated columns
            for (int c = 0; c < size; c++) {
                Set<Integer> columnSet = new HashSet<>();
                for (int r = 0; r < size; r++) {
                    if (!columnSet.add(matrix[r][c])) {
                        repeatedCols++;
                        break;
                    }
                }
            }

            // Calculate repeated rows
            for (int r = 0; r < size; r++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int c = 0; c < size; c++) {
                    if (!rowSet.add(matrix[r][c])) {
                        repeatedRows++;
                        break;
                    }
                }
            }

            // Display output
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }

        input.close();
    }
}