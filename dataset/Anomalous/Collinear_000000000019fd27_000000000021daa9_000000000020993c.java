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
            int repeatRows = 0;
            int repeatCols = 0;

            // Input matrix
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
                Set<Integer> colValues = new HashSet<>();
                for (int r = 0; r < size; r++) {
                    if (!colValues.add(matrix[r][c])) {
                        repeatCols++;
                        break;
                    }
                }
            }

            // Calculate repeated rows
            for (int r = 0; r < size; r++) {
                Set<Integer> rowValues = new HashSet<>();
                for (int c = 0; c < size; c++) {
                    if (!rowValues.add(matrix[r][c])) {
                        repeatRows++;
                        break;
                    }
                }
            }

            // Display output
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repeatRows + " " + repeatCols);
        }
    }
}