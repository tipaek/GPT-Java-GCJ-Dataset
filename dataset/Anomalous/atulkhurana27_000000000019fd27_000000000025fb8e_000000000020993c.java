import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int len = sc.nextInt();
            int trace = 0;
            int[][] matrix = new int[len][len];
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read matrix and compute trace
            for (int row = 0; row < len; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int col = 0; col < len; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                    if (!rowSet.add(matrix[row][col]) && !rowHasDuplicate) {
                        rowHasDuplicate = true;
                        rowRepeats++;
                    }
                }
            }

            // Check for column duplicates
            for (int col = 0; col < len; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int row = 0; row < len; row++) {
                    if (!colSet.add(matrix[row][col]) && !colHasDuplicate) {
                        colHasDuplicate = true;
                        colRepeats++;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}