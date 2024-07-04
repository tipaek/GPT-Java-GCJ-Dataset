import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            int caseNumber = 1;
            
            while (T-- > 0) {
                int N = Integer.parseInt(br.readLine());
                int[][] grid = new int[N][N];
                
                for (int i = 0; i < N; i++) {
                    String[] strArr = br.readLine().trim().split("\\s+");
                    for (int j = 0; j < N; j++) {
                        grid[i][j] = Integer.parseInt(strArr[j]);
                    }
                }
                
                System.out.println("Case #" + caseNumber + ": " + calculateDiagonalSum(grid) + " " + countDuplicateRows(grid) + " " + countDuplicateColumns(grid));
                caseNumber++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean hasDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    private static int countDuplicateRows(int[][] grid) {
        int duplicateRowCount = 0;
        for (int[] row : grid) {
            if (hasDuplicate(row)) {
                duplicateRowCount++;
            }
        }
        return duplicateRowCount;
    }

    private static int countDuplicateColumns(int[][] grid) {
        int N = grid.length;
        int duplicateColumnCount = 0;
        
        for (int j = 0; j < N; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                if (!set.add(grid[i][j])) {
                    duplicateColumnCount++;
                    break;
                }
            }
        }
        return duplicateColumnCount;
    }

    private static int calculateDiagonalSum(int[][] grid) {
        int N = grid.length;
        int diagonalSum = 0;
        
        for (int i = 0; i < N; i++) {
            diagonalSum += grid[i][i];
        }
        return diagonalSum;
    }
}