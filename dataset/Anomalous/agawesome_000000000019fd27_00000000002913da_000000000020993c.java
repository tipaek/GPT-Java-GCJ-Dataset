import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Read the matrix and compute the trace
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = scanner.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            // Check for row repeats
            for (int j = 0; j < size; j++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasRepeat = false;
                for (int k = 0; k < size; k++) {
                    if (!rowSet.add(matrix[j][k])) {
                        rowRepeats++;
                        hasRepeat = true;
                        break;
                    }
                }
                if (hasRepeat) continue;
            }

            // Check for column repeats
            for (int k = 0; k < size; k++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasRepeat = false;
                for (int j = 0; j < size; j++) {
                    if (!colSet.add(matrix[j][k])) {
                        colRepeats++;
                        hasRepeat = true;
                        break;
                    }
                }
                if (hasRepeat) continue;
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}