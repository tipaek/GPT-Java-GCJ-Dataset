import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int dimension = scanner.nextInt();
            int[][] matrix = new int[dimension][dimension];
            int duplicateRows = 0;
            int duplicateColumns = 0;
            int trace = 0;
            
            for (int row = 0; row < dimension; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < dimension; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    rowSet.add(value);
                    if (row == col) {
                        trace += value;
                    }
                }
                if (rowSet.size() != dimension) {
                    duplicateRows++;
                }
            }
            
            for (int col = 0; col < dimension; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < dimension; row++) {
                    colSet.add(matrix[row][col]);
                }
                if (colSet.size() != dimension) {
                    duplicateColumns++;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}