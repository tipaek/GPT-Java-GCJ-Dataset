import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private int solve(Scanner scanner) {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] competition = new int[rows][cols];
        int[][] elimination = new int[rows][cols];
        
        // Initialize the competition and elimination matrices
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                competition[i][j] = scanner.nextInt();
                elimination[i][j] = 1;
            }
        }
        
        long result = 0;
        boolean shouldContinue = true;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while (shouldContinue) {
            shouldContinue = false;
            long intermediateResult = 0;
            
            // Calculate intermediate result and determine elimination
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    intermediateResult += competition[i][j];
                    
                    if (competition[i][j] == 0) {
                        continue;
                    }
                    
                    double sum = 0;
                    int count = 0;
                    
                    for (int[] direction : directions) {
                        int y = i, x = j;
                        
                        while (y >= 0 && y < rows && x >= 0 && x < cols) {
                            if ((x != j || y != i) && competition[y][x] > 0) {
                                count++;
                                sum += competition[y][x];
                                break;
                            }
                            x += direction[0];
                            y += direction[1];
                        }
                    }
                    
                    if (count > 0) {
                        sum /= count;
                        if (sum > competition[i][j]) {
                            elimination[i][j] = 0;
                            shouldContinue = true;
                        }
                    }
                }
            }
            
            result += intermediateResult;
            
            // Update competition matrix based on elimination matrix
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    competition[i][j] *= elimination[i][j];
                }
            }
        }
        
        return (int) result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        Solution solution = new Solution();
        
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": " + solution.solve(scanner));
        }
    }
}