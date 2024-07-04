import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static int countRows(int[][] matrix) {
        int[] row = new int[matrix.length];
        int res = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(row[matrix[i][j] - 1] != 0) {
                    res++;
                    break;
                } else {
                    row[matrix[i][j] - 1] = 1;
                }
            }
            Arrays.fill(row, 0);
        }
        return res;
    }


    public static int countColumns(int[][] matrix) {
        int[] column = new int[matrix.length];
        int res = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(column[matrix[j][i] - 1] != 0) {
                    res++;
                    break;
                } else {
                    column[matrix[j][i] - 1] = 1;
                }
            }
            Arrays.fill(column, 0);
        }
        return res;
    }


    public static int calcSum(int[][] matrix) {
        int res = 0;
        for(int i = 0; i < matrix.length;i++) {
            res += matrix[i][i];
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseN = scanner.nextInt();
        int testCase = 1;
        StringBuilder builder = new StringBuilder();
        while(testCase <= testCaseN) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int sum = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            //Case #x: k r c
            int k = calcSum(matrix);
            int r = countRows(matrix);
            int c = countColumns(matrix);
            builder.append("Case #" + testCase + ": " + " " + k + " " + r + " " + c + "\n");
            testCase++;
        }

        System.out.println(builder.toString());
    }
}
