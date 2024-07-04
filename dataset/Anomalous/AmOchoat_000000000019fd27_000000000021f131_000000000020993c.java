import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Exercise {

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int cases = Integer.parseInt(bf.readLine().trim());
            for (int caseIndex = 1; caseIndex <= cases; caseIndex++) {
                int n = Integer.parseInt(bf.readLine().trim());
                Integer[][] matrix = new Integer[n][n];

                for (int row = 0; row < n; row++) {
                    String[] elements = bf.readLine().trim().split(" ");
                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = Integer.parseInt(elements[col]);
                    }
                }

                int diagonalSum = calculateDiagonalSum(matrix, n);
                int repeatedRows = countRepeatedRows(matrix, n);
                int repeatedCols = countRepeatedCols(matrix, n);

                System.out.println("Case #" + caseIndex + ": " + diagonalSum + " " + repeatedRows + " " + repeatedCols);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateDiagonalSum(Integer[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countRepeatedRows(Integer[][] matrix, int n) {
        int count = 0;
        for (int row = 0; row < n; row++) {
            Set<Integer> seen = new HashSet<>();
            for (int col = 0; col < n; col++) {
                if (!seen.add(matrix[row][col])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int countRepeatedCols(Integer[][] matrix, int n) {
        int count = 0;
        for (int col = 0; col < n; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < n; row++) {
                if (!seen.add(matrix[row][col])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}