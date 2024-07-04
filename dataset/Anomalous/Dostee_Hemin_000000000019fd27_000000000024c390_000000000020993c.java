import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int trace = 0;
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    if (row == col) {
                        trace += value;
                    }
                }
            }
            
            int rowDuplicates = 0;
            for (int row = 0; row < size; row++) {
                boolean[] seen = new boolean[size];
                for (int col = 0; col < size; col++) {
                    int value = matrix[row][col] - 1;
                    if (seen[value]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[value] = true;
                }
            }
            
            int colDuplicates = 0;
            for (int col = 0; col < size; col++) {
                boolean[] seen = new boolean[size];
                for (int row = 0; row < size; row++) {
                    int value = matrix[row][col] - 1;
                    if (seen[value]) {
                        colDuplicates++;
                        break;
                    }
                    seen[value] = true;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}