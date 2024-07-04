import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfCases = sc.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            System.out.print("Case #" + caseNumber + ": ");
            processMatrix(sc);
        }
        sc.close();
    }

    public static void processMatrix(Scanner sc) {
        int size = sc.nextInt();
        int[][] matrix = new int[size][size];

        // Read matrix values
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Calculate trace
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        // Count rows with duplicate values
        int rowCountWithDuplicates = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> rowValues = new HashSet<>();
            boolean hasDuplicate = false;
            for (int j = 0; j < size; j++) {
                if (!rowValues.add(matrix[i][j])) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                rowCountWithDuplicates++;
            }
        }

        // Count columns with duplicate values
        int columnCountWithDuplicates = 0;
        for (int j = 0; j < size; j++) {
            HashSet<Integer> columnValues = new HashSet<>();
            boolean hasDuplicate = false;
            for (int i = 0; i < size; i++) {
                if (!columnValues.add(matrix[i][j])) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                columnCountWithDuplicates++;
            }
        }

        System.out.println(trace + " " + rowCountWithDuplicates + " " + columnCountWithDuplicates);
    }
}