import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(sc.next());
        int[] traces = new int[testCases];
        int[] rowCounts = new int[testCases];
        int[] colCounts = new int[testCases];

        for (int t = 0; t < testCases; t++) {
            int size = sc.nextInt();
            sc.nextLine();
            String[][] matrix = new String[size][size];

            for (int i = 0; i < size; i++) {
                matrix[i] = sc.nextLine().split(" ");
            }

            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += Integer.parseInt(matrix[i][i]);
            }
            traces[t] = trace;

            rowCounts[t] = countDuplicateRows(matrix, size);
            colCounts[t] = countDuplicateCols(matrix, size);
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + traces[i] + " " + rowCounts[i] + " " + colCounts[i]);
        }
    }

    private static int countDuplicateRows(String[][] matrix, int size) {
        int rowCount = 0;
        for (String[] row : matrix) {
            Set<String> uniqueElements = new HashSet<>(Arrays.asList(row));
            if (uniqueElements.size() < size) {
                rowCount++;
            }
        }
        return rowCount;
    }

    private static int countDuplicateCols(String[][] matrix, int size) {
        int colCount = 0;
        for (int col = 0; col < size; col++) {
            Set<String> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() < size) {
                colCount++;
            }
        }
        return colCount;
    }
}