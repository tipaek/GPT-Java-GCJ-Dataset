import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private int solve(Scanner in) {
        int rows = in.nextInt();
        int cols = in.nextInt();
        double[][] matrix = new double[rows][cols];
        int[][] eliminate = new int[rows][cols];
        
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                matrix[i][j] = in.nextInt();
                eliminate[i][j] = 1;
            }
        }

        int result = 0;
        boolean continueProcess = true;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while (continueProcess) {
            continueProcess = false;
            int sumMatrixValues = 0;
            
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    sumMatrixValues += matrix[i][j];
                    if (matrix[i][j] == 0) {
                        continue;
                    }
                    
                    double sumNeighbors = 0;
                    int neighborCount = 0;
                    
                    for (int[] direction : directions) {
                        int y = i, x = j;
                        while (y >= 0 && y < rows && x >= 0 && x < cols) {
                            if ((x != j || y != i) && matrix[y][x] > 0) {
                                neighborCount++;
                                sumNeighbors += matrix[y][x];
                                break;
                            }
                            x += direction[0];
                            y += direction[1];
                        }
                    }
                    
                    if (neighborCount > 0) {
                        sumNeighbors /= neighborCount;
                        if (sumNeighbors > matrix[i][j]) {
                            eliminate[i][j] = 0;
                            continueProcess = true;
                        }
                    }
                }
            }
            
            result += sumMatrixValues;
            
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    matrix[i][j] *= eliminate[i][j];
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        Solution sol = new Solution();
        
        for (int i = 1; i <= testCases; ++i) {
            System.out.println("Case #" + i + ": " + sol.solve(in));
        }
    }
}