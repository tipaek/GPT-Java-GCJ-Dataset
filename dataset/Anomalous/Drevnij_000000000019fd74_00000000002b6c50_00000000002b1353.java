import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int[][] pascalTriangle = new int[100][100];
        pascalTriangle[1][1] = 1;
        
        for (int i = 2; i < pascalTriangle.length; i++) {
            for (int j = 1; j < pascalTriangle[i].length; j++) {
                pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
            }
        }
        
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int targetSum = scanner.nextInt();
            StringBuilder result = new StringBuilder();
            
            int currentRow = 1;
            int currentCol = 1;
            int currentSum = pascalTriangle[currentRow][currentCol];
            result.append(currentRow).append(" ").append(currentCol).append("\n");
            
            if (currentSum < targetSum) {
                currentRow = 2;
                currentCol = 2;
                currentSum += pascalTriangle[currentRow][currentCol];
                result.append(currentRow).append(" ").append(currentCol).append("\n");
            }
            
            while (currentSum < targetSum) {
                currentRow++;
                if (currentSum + pascalTriangle[currentRow][currentCol] <= targetSum) {
                    currentSum += pascalTriangle[currentRow][currentCol];
                    result.append(currentRow).append(" ").append(currentCol).append("\n");
                } else {
                    currentRow--;
                    currentCol--;
                    currentSum += pascalTriangle[currentRow][currentCol];
                    result.append(currentRow).append(" ").append(currentCol).append("\n");
                }
            }
            
            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}