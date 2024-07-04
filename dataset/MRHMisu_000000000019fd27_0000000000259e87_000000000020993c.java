import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfTestCase = scan.nextInt();
        for (int test_no = 0; test_no < numberOfTestCase; test_no++) {
            int N = scan.nextInt();
            int[][] matrix = new int[4][4];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }
            System.out.println(calculateVestigiumMeans((test_no + 1), N, matrix));
        }
    }

    static String calculateVestigiumMeans(int t_no, int N, int[][] matrix) {

        int diagonalSum = 0;
        int duplicateRow = 0;
        int duplicateColumn = 0;

        for (int i = 0; i < N; i++) {
            diagonalSum += matrix[i][i];
        }

        // count duplicate row
        for (int i = 0; i < N; i++) {
            int[] row = matrix[i];
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (!set.contains(row[j])) {
                    set.add(row[j]);
                } else {
                    duplicateRow++;
                    break;
                }
            }
        }
        //count duplicate column
        for (int i = 0; i < N; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (!set.contains(matrix[j][i])) {
                    set.add(matrix[j][i]);
                } else {
                    duplicateColumn++;
                    break;
                }
            }
        }
        String result = "Case #" + t_no + ": " + diagonalSum + " " + duplicateRow + " " + duplicateColumn;
        return result;
    }
}
