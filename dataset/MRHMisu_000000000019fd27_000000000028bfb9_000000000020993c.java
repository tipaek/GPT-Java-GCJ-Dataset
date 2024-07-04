import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
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

        for (int i = 0; i < N; i++) {
            HashSet<Integer> rowSet = new HashSet<Integer>();
            for (int j = 0; j < N; j++) {
                if (rowSet.contains(matrix[i][j])) {
                    duplicateRow++;
                    break;
                } else rowSet.add(matrix[i][j]);
            }
            HashSet<Integer> collumnSet = new HashSet<Integer>();
            for (int j = 0; j < N; j++) {
                if (collumnSet.contains(matrix[j][i])) {
                    duplicateColumn++;
                    break;
                } else collumnSet.add(matrix[j][i]);
            }
        }
        String result = "Case #" + t_no + ": " + diagonalSum + " " + duplicateRow + " " + duplicateColumn;
        return result;
    }
}
