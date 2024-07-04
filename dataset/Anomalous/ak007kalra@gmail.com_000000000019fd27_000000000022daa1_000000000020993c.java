import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            int[][] matrix = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = input.nextInt();
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int colDuplicates = countColDuplicates(matrix, n);

            System.out.println("Case #" + i + ": " + diagonalSum + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int calculateDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;

        for (int row = 0; row < size; row++) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int col = 0; col < size; col++) {
                if (hashMap.containsKey(matrix[row][col])) {
                    duplicateCount++;
                    break;
                } else {
                    hashMap.put(matrix[row][col], 1);
                }
            }
        }

        return duplicateCount;
    }

    private static int countColDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;

        for (int col = 0; col < size; col++) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int row = 0; row < size; row++) {
                if (hashMap.containsKey(matrix[row][col])) {
                    duplicateCount++;
                    break;
                } else {
                    hashMap.put(matrix[row][col], 1);
                }
            }
        }

        return duplicateCount;
    }
}