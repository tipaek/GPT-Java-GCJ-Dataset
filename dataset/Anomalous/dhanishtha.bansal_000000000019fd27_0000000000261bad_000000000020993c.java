import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int testCases = Integer.parseInt(br.readLine()); 
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            int maxSum = (n * (n + 1)) / 2;
            int[] colSum = new int[n];
            int diagSum = 0;
            int invalidRows = 0;
            int invalidCols = 0;

            Arrays.fill(colSum, maxSum);
            
            for (int i = 0; i < n; i++) {
                int rowSum = maxSum;
                String[] values = br.readLine().trim().split(" ");
                
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                    rowSum -= matrix[i][j];
                    colSum[j] -= matrix[i][j];
                    if (i == j) {
                        diagSum += matrix[i][j];
                    }
                }
                
                if (rowSum != 0) {
                    invalidRows++;
                }
            }
            
            for (int sum : colSum) {
                if (sum != 0) {
                    invalidCols++;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + diagSum + " " + invalidRows + " " + invalidCols);
            caseNumber++;
        }
    }
}