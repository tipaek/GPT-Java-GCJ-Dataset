import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k =0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            solve(t, n, matrix);
        }
    }
    
    public static void solve(int index, int n, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }
        
        int rowDup = 0;
        int colDup = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(matrix[i][j]);
            }
            if (hasDuplicate(row))
                rowDup++;
            
            
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                col.add(matrix[j][i]);
            }
            if (hasDuplicate(col))
                colDup++;
        }
        
        System.out.println("Case #" + index + ": " + trace + " " + rowDup + " " + colDup);
    }
    
    public static boolean hasDuplicate(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        for (int item : list)
            if (!set.add(item))
                return true;
        return false;
    }
}