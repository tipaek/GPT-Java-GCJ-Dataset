import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int k = 1; k<=n; ++k) {
            
                for (int j = 1; j <= n; ++j) {
                    matrix[k - 1][j - 1] = in.nextInt();
                }
    
            }
            int[] ansArray = calculateMatrix(matrix);
    
            System.out.println("Case #" + i + ": " + ansArray[0] + " " + ansArray[1] + " " + ansArray[2]);
            
        }   
        
    }

    public static int[] calculateMatrix(int[][] matrix) {
        int[] array = new int[3];
        for (int i = 0; i < matrix.length; ++i) {
            array[0] += matrix[i][i];
            if (isRepRow(matrix, i)) {
                array[1] += 1;
            }
            if (isRepColumn(matrix, i)) {
                array[2] += 1;
            }
        }
        return array;
    }

    public static boolean isRepRow(int[][] matrix, int row) {

        boolean[] boolArray = new boolean[matrix.length + 1];
        Arrays.fill(boolArray, Boolean.FALSE);
        for (int i = 0; i < matrix.length; i++) {
            if (boolArray[matrix[row][i]]) {
                return true;
            } else {
                boolArray[matrix[row][i]] = true;
            }
        }
        return false;
    }

    public static boolean isRepColumn(int[][] matrix, int column) {

        boolean[] boolArray = new boolean[matrix.length + 1];
        Arrays.fill(boolArray, Boolean.FALSE);
        for (int i = 0; i < matrix.length; i++) {
            if (boolArray[matrix[i][column]]) {
                return true;
            } else {
                boolArray[matrix[i][column]] = true;
            }
        }
        return false;
    }
}
