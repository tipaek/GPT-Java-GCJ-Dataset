import java.util.Scanner;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            int[][] matrix = new int[n][n];
            HashSet<Integer> uniqueElements = new HashSet<>();

            // Read matrix and calculate trace and row duplicates
            for (int i = 0; i < n; i++) {
                uniqueElements.clear();
                boolean rowHasDuplicates = false;

                for (int j = 0; j < n; j++) {
                    int element = scanner.nextInt();
                    matrix[i][j] = element;

                    if (i == j) {
                        trace += element;
                    }

                    if (!uniqueElements.add(element) && !rowHasDuplicates) {
                        rowDuplicates++;
                        rowHasDuplicates = true;
                    }
                }
            }

            // Calculate column duplicates
            for (int j = 0; j < n; j++) {
                uniqueElements.clear();
                for (int i = 0; i < n; i++) {
                    if (!uniqueElements.add(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}