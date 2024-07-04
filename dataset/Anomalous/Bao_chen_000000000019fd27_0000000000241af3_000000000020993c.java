import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                }
            }
            
            processCase(caseNum, matrix);
        }
    }
    
    private static int checkColumn(int colIndex, int[][] matrix) {
        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int row = 0; row < matrix.length; row++) {
            uniqueElements.add(matrix[row][colIndex]);
        }
        return uniqueElements.size() < matrix.length ? 1 : 0;
    }
    
    private static int checkRow(int rowIndex, int[][] matrix) {
        HashSet<Integer> uniqueElements = new HashSet<>();
        for (int col = 0; col < matrix.length; col++) {
            uniqueElements.add(matrix[rowIndex][col]);
        }
        return uniqueElements.size() < matrix.length ? 1 : 0;
    }
    
    private static void processCase(int caseNum, int[][] matrix) {
        int trace = 0, rowRepeats = 0, colRepeats = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
            rowRepeats += checkRow(i, matrix);
            colRepeats += checkColumn(i, matrix);
        }
        
        System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
    }
}