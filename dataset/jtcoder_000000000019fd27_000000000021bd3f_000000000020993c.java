import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private int traceOfMatrix(int[][] matrix) {
        int sum = 0;
        for (int j = 0; j < matrix.length; j++) {
            sum = sum + matrix[j][j];

        }
        return sum;
    }

    private int rowsWithRepeatedElements(int[][] matrix) {
        int count = 0;
        for (int j = 0; j < matrix.length; j++) {
            HashSet<Integer> items = new HashSet<Integer>();
            for (int k = 0; k < matrix.length; k++) {
                items.add(matrix[j][k]);
            }
            if (matrix.length != items.size()) {
                count++;
            }
        }
        return count;
    }

    private int colsWithRepeatedElements(int[][] matrix) {
        int count = 0;
        for (int j = 0; j < matrix.length; j++) {
            HashSet<Integer> items = new HashSet<Integer>();
            for (int k = 0; k < matrix.length; k++) {
                items.add(matrix[k][j]);
            }
            if (matrix.length != items.size()) {
                count++;
            }
        }
        return count;
    }

    private void run() throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + traceOfMatrix(matrix) + " " + rowsWithRepeatedElements(matrix) + " " + colsWithRepeatedElements(matrix));
        }
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

}
