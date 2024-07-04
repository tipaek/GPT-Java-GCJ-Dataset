import java.util.*;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        for (int i = 0; i < size; i++) {
            int n = scan.nextInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            int[][] matrix = new int[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    matrix[x][y] = scan.nextInt();
                    if (x == y) {
                        trace += matrix[x][y];
                    }
                }
            }

            // Check for row duplicates
            for (int x = 0; x < n; x++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int y = 0; y < n; y++) {
                    if (!rowSet.add(matrix[x][y])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for column duplicates
            for (int y = 0; y < n; y++) {
                Set<Integer> colSet = new HashSet<>();
                for (int x = 0; x < n; x++) {
                    if (!colSet.add(matrix[x][y])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }

        scan.close();
    }
}