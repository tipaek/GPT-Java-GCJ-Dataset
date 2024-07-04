import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int ntests = sc.nextInt();
        for (int i = 0; i < ntests; i++) {
            int rows = sc.nextInt();
            process(rows, i + 1);
        }
    }

    public static void process(int rows, int ncase) {
        int sum = 0;
        int[][] matrix = new int[rows][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < rows; col++) {
                int value = sc.nextInt();
                matrix[row][col] = value;
                if (row == col) {
                    sum += value;
                }
            }
        }

        int rowCount = 0;
        for (int row = 0; row < rows; row++) {
            if (hasDuplicates(matrix[row])) {
                rowCount++;
            }
        }

        int colCount = 0;
        for (int col = 0; col < rows; col++) {
            if (hasDuplicates(getColumn(matrix, col))) {
                colCount++;
            }
        }

        System.out.println("Case #" + ncase + ": " + sum + " " + rowCount + " " + colCount);
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static int[] getColumn(int[][] matrix, int column) {
        int[] colArray = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            colArray[i] = matrix[i][column];
        }
        return colArray;
    }
}