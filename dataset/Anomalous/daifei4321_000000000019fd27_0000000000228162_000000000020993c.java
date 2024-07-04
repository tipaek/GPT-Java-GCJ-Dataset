import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int[][] grid = new int[N][N];
            
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    grid[y][x] = scanner.nextInt();
                }
            }
            
            int trace = 0;
            for (int i = 0; i < N; i++) {
                trace += grid[i][i];
            }
            
            int[] buffer = new int[N + 1];
            int duplicateRows = 0, duplicateCols = 0;
            
            for (int y = 0; y < N; y++) {
                Arrays.fill(buffer, 0);
                for (int x = 0; x < N; x++) {
                    if (++buffer[grid[y][x]] > 1) {
                        duplicateRows++;
                        break;
                    }
                }
            }
            
            for (int x = 0; x < N; x++) {
                Arrays.fill(buffer, 0);
                for (int y = 0; y < N; y++) {
                    if (++buffer[grid[y][x]] > 1) {
                        duplicateCols++;
                        break;
                    }
                }
            }
            
            System.out.println("CASE #" + t + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
        
        scanner.close();
    }
}