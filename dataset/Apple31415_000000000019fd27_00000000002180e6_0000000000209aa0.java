import java.io.*;
import java.util.*;

public class Solution {
    
    static int depth = 0;
    static int[] diag = new int[1];
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numcases = Integer.parseInt(br.readLine());
        for (int i = 0; i < numcases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int trace = Integer.parseInt(st.nextToken());
            
            diag = checker(size, trace);
            if (diag.length == 0) {
                System.out.printf("Case #%d: %s%n", i + 1, "IMPOSSIBLE");
                continue;
            }
            
            boolean[][] curr = new boolean[size][size];
            for (int j = 0; j < size; j++)
                curr[j][diag[j]] = true;
            
            int[][] matrix = new int[size][size];
            for (int j = 0; j < size; j++) {
                matrix[j][j] = diag[j];
            }
            
            boolean[] row = new boolean[size];
            row[diag[0]] = true;
            generator(matrix, 0, 0, curr, row);
            System.out.printf("Case #%d: %s%n", i + 1, "POSSIBLE");
            printmatrix(matrix);
        }
    }
    
    public static void printmatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell: row) 
                System.out.print(String.valueOf(cell + 1).concat(" "));
            System.out.println();
        }
    }
    
    public static boolean generator(int[][] matrix, int row, int col, boolean[][] columns, boolean[] rows) {
        if (col >= matrix.length) {
            boolean[] hold = new boolean[matrix.length];
            if (row != matrix.length - 1)
                hold[diag[row + 1]] = true;
            return generator(matrix, row + 1, 0, columns, hold);
        }
        if (row >= matrix.length)
            return true;
        if (row == col)
            return generator(matrix, row, col + 1, columns, rows);
        
        for (int i = 0; i < matrix.length; i++) {
            if (columns[col][i] || rows[i]) continue;
            matrix[row][col] = i;
            columns[col][i] = true;
            rows[i] = true;
            if (generator(matrix, row, col + 1, columns, rows))
                return true;
            columns[col][i] = false;
            rows[i] = false;
        }
        matrix[row][col] = 0;
        return false;
    }
    
    public static int[] checker(int size, int trace) {
        if (size == 2 && trace == 3)
            return new int[0];
        if (size == 3 && (trace == 5 || trace == 7))
            return new int[0];
        if (trace == size * size - 1 || trace == size + 1)
            return new int[0];
        trace -= size;
        int[] ret = new int[size];
        if (trace % size == 1) {
            ret[0] = trace / size - 1;
            for (int i = 1; i < size - 2; i++)
                ret[i] = trace / size;
            ret[size - 2] = ret[size - 1] = trace / size + 1;
            return ret;
        }
        if (trace % size == size - 1) {
            ret[0] = trace / size + 2;
            for (int i = 1; i < size - 2; i++)
                ret[i] = trace / size + 1;
            ret[size - 2] = ret[size - 1] = trace / size;
            return ret;
        }
        int num = trace % size;
        for (int i = 0; i < num; i++) {
            ret[i] = trace / size + 1;
        }
        for (int i = num; i < size; i++) {
            ret[i] = trace / size;
        }
        return ret;
    }
    
}