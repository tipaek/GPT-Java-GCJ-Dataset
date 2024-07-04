import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public int countRepeatedRows(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public int countRepeatedColumns(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[j][i])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        Solution solution = new Solution();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int diagonalSum = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                }
            }

            int repeatedRows = solution.countRepeatedRows(matrix, size);
            int repeatedColumns = solution.countRepeatedColumns(matrix, size);

            System.out.println("Case #" + t + ": " + diagonalSum + " " + repeatedRows + " " + repeatedColumns);
        }
        scanner.close();
    }
}