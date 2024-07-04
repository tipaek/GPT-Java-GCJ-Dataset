import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;
            int rowDuplicates = 0;
            int columnDuplicates = 0;

            // Reading matrix and checking row duplicates
            for (int row = 0; row < size; row++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean hasRowDuplicate = false;
                for (int col = 0; col < size; col++) {
                    int number = scanner.nextInt();
                    if (!rowSet.add(number)) {
                        hasRowDuplicate = true;
                    }
                    matrix[row][col] = number;
                    if (row == col) {
                        diagonalSum += number;
                    }
                }
                if (hasRowDuplicate) {
                    rowDuplicates++;
                }
            }

            // Checking column duplicates
            for (int col = 0; col < size; col++) {
                Set<Integer> colSet = new HashSet<>();
                boolean hasColDuplicate = false;
                for (int row = 0; row < size; row++) {
                    int number = matrix[row][col];
                    if (!colSet.add(number)) {
                        hasColDuplicate = true;
                    }
                }
                if (hasColDuplicate) {
                    columnDuplicates++;
                }
            }

            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + rowDuplicates + " " + columnDuplicates);
        }
        scanner.close();
    }
}