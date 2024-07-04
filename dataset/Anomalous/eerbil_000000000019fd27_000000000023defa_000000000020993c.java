import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int numCases = scanner.nextInt();
        int[] sums = new int[numCases];
        int[] rows = new int[numCases];
        int[] cols = new int[numCases];
        
        for (int i = 0; i < numCases; i++) {
            int numRows = scanner.nextInt();
            int[][] matrix = new int[numRows][numRows];
            
            for (int j = 0; j < numRows; j++) {
                for (int k = 0; k < numRows; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }
            
            int sum = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            
            for (int j = 0; j < numRows; j++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                
                for (int k = 0; k < numRows; k++) {
                    if (j == k) {
                        sum += matrix[j][k];
                    }
                    
                    if (!rowSet.add(matrix[j][k])) {
                        rowDuplicates++;
                        break;
                    }
                }
                
                for (int k = 0; k < numRows; k++) {
                    if (!colSet.add(matrix[k][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }
            
            sums[i] = sum;
            rows[i] = rowDuplicates;
            cols[i] = colDuplicates;
        }
        
        scanner.close();
        
        for (int i = 0; i < numCases; i++) {
            System.out.println(sums[i] + " " + rows[i] + " " + cols[i]);
        }
    }
}