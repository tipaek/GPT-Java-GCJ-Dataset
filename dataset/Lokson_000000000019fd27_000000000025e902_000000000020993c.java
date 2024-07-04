import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= testCases; ++i) {
            int size = in.nextInt();
            int[][] matrix = populateMatrix(in, size);
        }
    }

    private static int[][] populateMatrix(Scanner in, int size) {
        // [column][row]
        int[][] matrix = new int[size][size];
        for(int i = 0; i < size; i++) {
            String[] s = in.nextLine().split(" ");
            for(int j = 0; j < size; j++) {
                matrix[j][i] = Integer.valueOf(s[j]);
            }
        }
        return matrix;
    }
    
    private static void print(int[][] matrix, int size) {
        for(int i = 0; i < size; i++) {
            System.out.println();
            for(int j = 0; j < size; j++) {
                System.out.print(matrix[j][i] + " ");
            }
        }
    }
}