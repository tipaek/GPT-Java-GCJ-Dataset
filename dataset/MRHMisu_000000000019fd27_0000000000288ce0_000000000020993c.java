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


        int sum = (N * (N + 1) / 2);

        //count duplicate column

        for (int i = 0; i < N; i++) {
            Map<Integer, Integer> rowMap = new HashMap<>();
            Map<Integer, Integer> columnMap = new HashMap<>();
            for (int j = 0; j < N; j++) {
                if (i == j) diagonalSum += matrix[i][j];
                rowMap.put(matrix[i][j], matrix[i][j]);
                columnMap.put(matrix[j][i], matrix[j][i]);
            }
            if (rowMap.keySet().size() < N) duplicateRow++;
            if (columnMap.keySet().size() < N) duplicateColumn++;
        }
        String result = "Case #" + t_no + ": " + diagonalSum + " " + duplicateRow + " " + duplicateColumn;
        return result;
    }
}
