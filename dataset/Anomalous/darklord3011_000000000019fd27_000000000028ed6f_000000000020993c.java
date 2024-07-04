import java.util.Scanner;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int rowDuplicates = 0;
            int columnDuplicates = 0;
            int trace = 0;
            
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                HashSet<Integer> columnSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!columnSet.add(matrix[j][i])) {
                        columnDuplicates++;
                        break;
                    }
                }
            }
            
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }
            
            System.out.printf("Case #%d: %d %d %d%n", t, trace, rowDuplicates, columnDuplicates);
        }
        
        scanner.close();
    }
}