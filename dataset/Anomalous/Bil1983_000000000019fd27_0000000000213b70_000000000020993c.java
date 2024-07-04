import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = sc.nextInt();
        
        for (int test = 1; test <= t; test++) {
            int N = sc.nextInt();
            sc.nextLine();
            
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }
            
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() != N) rowRepeats++;
                if (colSet.size() != N) colRepeats++;
            }
            
            System.out.println("Case #" + test + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        sc.close();
    }
}