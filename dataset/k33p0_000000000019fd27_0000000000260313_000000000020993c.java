import java.util.*;
import java.io.*;
public class Solution {
    
    public static int calcTrace(int[][] matrix) {
        int size = matrix[0].length;
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static int calcDuplicate(int[][] matrix, boolean forRow) {
        int size = matrix[0].length;
        int count = 0;
        int[] arr = new int[size]; // since numbers are from 1 to n
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int value;
                if (forRow) { // calculate row duplicate
                    value = matrix[i][j];
                    arr[value - 1]++;
                } else { // calculate col duplicate
                    value = matrix[j][i];
                    arr[value - 1]++;
                }
            }

            // check for duplicates in row
            for (int k = 0; k < size; k++) {
                if (arr[k] > 1) {
                    count++;
                    break;
                }
            }
            // reset
            Arrays.fill(arr, 0);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= cases; ++i) {
            int lines = in.nextInt();
            int[][] matrix = new int[lines][lines];
            for (int j = 0; j < lines; j++) {
                for (int k = 0; k < lines; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            System.out.println("Case #" + i + ": " + calcTrace(matrix) + " " + calcDuplicate(matrix, true) + 
                    " " + calcDuplicate(matrix, false));
        }
    }
}
