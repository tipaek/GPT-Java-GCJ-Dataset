import java.util.Scanner;

/**
 *
 * @author vinhtd2
 */
public class Solution {

    public static String processMatrix(int caseNum, int[][] matrix) {

        int k = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < matrix.length; i++) {
            k = k + matrix[i][i];
            // row
            for (int j = 1; j < matrix[i].length; j++) {
                int key = matrix[i][j];
                int l = j - 1;
                boolean isStop = false;
                while (l >= 0) {
                    if (matrix[i][l] == key) {
                        r = r + 1;
                        isStop = true;
                        break;
                    }
                    l = l - 1;
                }
                if (isStop) {
                    break;
                }

            }
            // column
            for (int j = 1; j < matrix.length; j++) {
                int key = matrix[j][i];
                int l = j - 1;
                boolean isStop = false;
                while (l >= 0) {
                    if (matrix[l][i] == key) {
                        c = c + 1;
                        isStop = true;
                        break;
                    }
                    l = l - 1;
                }
                if (isStop) {
                    break;
                }
            }
        }
        return ("Case #" + (caseNum + 1) + ": " + " " + k + " " + r + " " + c);
    }

    public static void main(String[] args) {
        int m[][] = {
            {1, 2, 3, 4},
            {2, 1, 4, 3},
            {3, 4, 1, 2},
            {4, 3, 2, 1}
        };
        int m2[][] = {
            {2, 2, 2, 2},
            {2, 3, 2, 3},
            {2, 2, 2, 3},
            {2, 2, 2, 2},
        };
        int m3[][] = {
            {2, 1, 3},
            {1, 3, 2},
            {1, 2, 3}
        };
        System.out.println(processMatrix(0, m));
        System.out.println(processMatrix(0, m2));
        System.out.println(processMatrix(0, m3));
    }
}
