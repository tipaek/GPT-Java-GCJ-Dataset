import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for (int test = 1; test <= t; test++) {
            int N = sc.nextInt();
            sc.nextLine();
            int[][] matrix = readMatrix(N, N);
            
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            List<Set<Integer>> rowSets = new ArrayList<>();
            List<Set<Integer>> colSets = new ArrayList<>();
            
            // Calculate the trace of the matrix
            for (int i = 0; i < N; i++) {
                trace += matrix[i][i];
            }
            
            // Create sets for rows and columns
            for (int i = 0; i < N; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < N; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                rowSets.add(rowSet);
                colSets.add(colSet);
            }
            
            // Count rows with duplicates
            for (Set<Integer> rowSet : rowSets) {
                if (rowSet.size() != N) {
                    rowDuplicates++;
                }
            }
            
            // Count columns with duplicates
            for (Set<Integer> colSet : colSets) {
                if (colSet.size() != N) {
                    colDuplicates++;
                }
            }
            
            System.out.println("Case #" + test + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int[][] readMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }
}