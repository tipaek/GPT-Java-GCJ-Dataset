import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.hasNextLine() ? Integer.parseInt(scanner.nextLine()) : 0;

        for (int i = 0; i < cases; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[size][size];

            for (int j = 0; j < size; j++) {
                String[] row = scanner.nextLine().split(" ");
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = Integer.parseInt(row[k]);
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + calculateMatrixMetrics(matrix));
        }
    }

    private static String calculateMatrixMetrics(int[][] matrix) {
        int trace = 0;
        int rowRepeats = 0;
        int colRepeats = 0;

        Set<String> colEntries = new HashSet<>();
        Set<Integer> duplicateCols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> rowEntries = new HashSet<>();
            boolean rowHasDuplicate = false;

            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];

                if (i == j) {
                    trace += value;
                }

                String colEntry = j + "," + value;
                if (colEntries.contains(colEntry) && !duplicateCols.contains(j)) {
                    colRepeats++;
                    duplicateCols.add(j);
                } else {
                    colEntries.add(colEntry);
                }

                if (rowEntries.contains(value) && !rowHasDuplicate) {
                    rowRepeats++;
                    rowHasDuplicate = true;
                } else {
                    rowEntries.add(value);
                }
            }
        }

        return trace + " " + rowRepeats + " " + colRepeats;
    }
}