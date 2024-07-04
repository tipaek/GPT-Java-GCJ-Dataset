import java.util.*;
import java.io.*;

public class Vestigium {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = input.nextInt();
        
        for (int t = 1; t <= testCaseCount; t++) {
            int trace = 0;
            int repeatedRows = 0;
            int repeatedColumns = 0;
            int N = input.nextInt();
            int[][] matrix = new int[N][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }
            
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
                
                if (rowSet.size() != N) {
                    repeatedRows++;
                }
                
                if (colSet.size() != N) {
                    repeatedColumns++;
                }
            }
            
            System.out.println("Case #" + t + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
        
        input.close();
    }
}