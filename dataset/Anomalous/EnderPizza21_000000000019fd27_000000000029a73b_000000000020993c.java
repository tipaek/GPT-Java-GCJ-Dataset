import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int size = Integer.parseInt(br.readLine());
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix);
            int repeatedRows = countRepeatedRows(matrix);
            int repeatedCols = countRepeatedCols(matrix);

            System.out.printf("Case #%d: %d %d %d%n", caseNum, diagonalSum, repeatedRows, repeatedCols);
        }
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countRepeatedRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int element : row) {
                uniqueElements.add(element);
            }
            if (uniqueElements.size() < matrix.length) {
                count++;
            }
        }
        return count;
    }

    private static int countRepeatedCols(int[][] matrix) {
        int count = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int[] row : matrix) {
                uniqueElements.add(row[col]);
            }
            if (uniqueElements.size() < matrix.length) {
                count++;
            }
        }
        return count;
    }
}