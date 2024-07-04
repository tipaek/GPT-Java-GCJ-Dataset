import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt(); 
        for (int idx=1; idx<=N; ++idx) {
            int[][] matrix = getMatrix(in);
            int diag = getDiag(matrix);
            int rows = getRows(matrix);
            int cols = getCols(matrix);
            System.out.printf("Case #%d: %d %d %d\n", idx, diag, rows, cols);
        }
    }
    
    static int[][] getMartix(Scanner in){
        int size = in.nextInt();
        int[][] matrix = new int[size][size];
        for (int row=0; row<size; ++row) {
            for (int col=0; col<size; ++col) {
                matrix[row][col] = in.nextInt();
            }
        }
        return matrix;
    }
    
    static int getDiag(int[][] matrix) {
        int res = 0;
        for (int idx=0; idx<matrix.length; ++idx){
            res += matrix[idx][idx];
        }
        return res;
    }
    
    static int getRows(int[][] matrix) {
        int res = 0;
        int expectedLower = getExpected(matrix.length);
        int expectedUpper = getExpected(matrix.length);
        for (int row=0; row<matrix.length; ++row) {
            int lower = 0;
            int upper = 0;
            for (int el=0; el<matrix.length; ++el) {
                if (matrix[row][el] > 50){
                    upper += 1 << (matrix[row][el] - 50); 
                } else {
                    lower += 1 << (matrix[row][el]); 
                }
            }
            if (lower != expectedLower || upper != expectedUpper) {
                ++res;
            }
        }
        return res;
    }
    
    static int getCols(int[][] matrix) {
        int res = 0;
        int expectedLower = getExpected(matrix.length);
        int expectedUpper = getExpected(matrix.length);
        for (int row=0; row<matrix.length; ++row) {
            int lower = 0;
            int upper = 0;
            for (int el=0; el<matrix.length; ++el) {
                if (matrix[el][row] > 50){
                    upper += 1 << (matrix[el][row] - 50); 
                } else {
                    lower += 1 << (matrix[el][row]); 
                }
            }
            if (lower != expectedLower || upper != expectedUpper) {
                ++res;
            }
        }
        return res;
        
        return res;
    }
    
    static int getExpected(int size) {
        if (size <= 0)
            return 0;
        if (size > 50) {
            size = 50;
        }
        int res = 0;
        for (int idx=0; idx<=size; ++idx) {
            res += 1<<idx; 
        }
    }
    
}