import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int testN = input.nextInt();
        
        for (int i = 0; i < testN; i++) {
            int mSize = input.nextInt();
            int[][] matrix = new int[mSize][mSize];
            
            for (int j = 0; j < mSize; j++) {
                for (int k = 0; k < mSize; k++) {
                    matrix[j][k] = input.nextInt();
                }
            }
            
            int k = 0, r = 0, c = 0;
            
            // Calculate trace
            for (int j = 0; j < mSize; j++) {
                k += matrix[j][j];
            }

            // Check for duplicate values in rows
            for (int j = 0; j < mSize; j++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int l = 0; l < mSize; l++) {
                    rowSet.add(matrix[j][l]);
                }
                if (rowSet.size() != mSize) {
                    r++;
                }
            }

            // Check for duplicate values in columns
            for (int j = 0; j < mSize; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int l = 0; l < mSize; l++) {
                    colSet.add(matrix[l][j]);
                }
                if (colSet.size() != mSize) {
                    c++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
        }
    }
}