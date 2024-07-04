import java.util.*;
import java.io.*;

public class Solution {
    public static boolean isLatinArray(int[] row) {
        int temp;
        for (int i = 1; i < row.length; i++) {
            while (row[i] != i) {
                temp = row[row[i]];
                if (temp == row[i]) return false;
                row[row[i]] = row[i];
                row[i] = temp;
            }
        }
        return true;
    }

    public static int[] getVestigium(int[][] matrix) {
        int[] result = new int[3];
        int[] arr = new int[matrix.length];
        
        for (int i = 1; i < matrix.length; i++) {
            result[0] += matrix[i][i];
            
            arr = Arrays.copyOf(matrix[i], matrix[i].length);
            if (!isLatinArray(arr)) result[1]++;
            
            for (int j = 1; j < matrix.length; j++) {
                arr[j] = matrix[j][i];
            }
            if (!isLatinArray(arr)) result[2]++;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n + 1][n + 1];
            
            for (int row = 1; row <= n; row++) {
                for (int col = 1; col <= n; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            int[] result = getVestigium(matrix);
            System.out.println("Case #" + t + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
        
        scanner.close();
    }
}