import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[][] m = new int[N][N];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    m[row][col] = scanner.nextInt();
                }
            }
            int trace = trace(m);
            int rowsWithDups = rowsWithDups(m);
            transpose(m);
            int colsWithDups = rowsWithDups(m);
            System.out.println(String.format(
                "Case #%d: %d %d %d",
                t + 1,
                trace,
                rowsWithDups,
                colsWithDups
                ));
        }
    }
    
    private static int trace(int[][] m) {
        int sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }
        return sum;
    }
    
    private static int rowsWithDups(int[][] m) {
        return (int) Stream.of(m)
            .filter(row -> hasDuplicates(row))
            .count();
    }
    
    private static boolean hasDuplicates(int[] nums) {
        boolean[] seen = new boolean[nums.length];
        for (int v : nums) {
            if (seen[v-1]) return true;
            seen[v-1] = true;
        }
        return false;
    }
    
    private static void transpose(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = i + 1; j < m.length; j++) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }
    }
}