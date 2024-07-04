import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < caseCount; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[N][N];
            
            for (int j = 0; j < N; j++) {
                String[] line = scanner.nextLine().split(" ");
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.parseInt(line[k]);
                }
            }
            
            String result = solve(matrix, i + 1);
            System.out.println(result);
        }
        
        scanner.close();
    }

    public static String solve(int[][] matrix, int index) {
        int N = matrix.length;
        int trace = 0, rowCount = 0, colCount = 0;

        // Calculate the trace
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }

        // Check for duplicate values in rows
        for (int i = 0; i < N; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowCount++;
                    break;
                }
            }
        }

        // Check for duplicate values in columns
        for (int i = 0; i < N; i++) {
            HashSet<Integer> colSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (!colSet.add(matrix[j][i])) {
                    colCount++;
                    break;
                }
            }
        }

        return String.format("Case #%d: %d %d %d", index, trace, rowCount, colCount);
    }
}