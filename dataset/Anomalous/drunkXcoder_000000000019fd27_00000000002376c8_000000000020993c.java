import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int c = 1; c <= t; c++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().trim().split("\\s+");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }

            // Transposing the matrix
            int[][] transposedArr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    transposedArr[i][j] = arr[j][i];
                }
            }

            // Calculating the sum of the main diagonal
            int diagonalSum = 0;
            for (int i = 0; i < n; i++) {
                diagonalSum += arr[i][i];
            }

            // Finding the number of rows with duplicate elements
            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                Arrays.sort(arr[i]);
                if (hasDuplicates(arr[i])) {
                    duplicateRows++;
                }
            }

            // Finding the number of columns with duplicate elements
            int duplicateColumns = 0;
            for (int i = 0; i < n; i++) {
                Arrays.sort(transposedArr[i]);
                if (hasDuplicates(transposedArr[i])) {
                    duplicateColumns++;
                }
            }

            // Printing the result
            System.out.println("Case #" + c + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }

    // Helper method to check for duplicates in a sorted array
    private static boolean hasDuplicates(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                return true;
            }
        }
        return false;
    }
}