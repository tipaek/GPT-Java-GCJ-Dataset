import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int testCases = scan.nextInt();
        
        System.out.print("Enter the size of the matrix: ");
        int size = scan.nextInt();
        
        int[][] matrix = new int[size][size];
        
        while (testCases > 0) {
            System.out.println("Enter the values for the matrix:");
            for (int i = 0; i < size; i++) {
                System.out.print("[ ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scan.nextInt();
                }
                System.out.println("]");
            }
            
            System.out.println("Case #" + testCases + ":");
            System.out.println("Trace of matrix: " + calculateTrace(matrix));
            System.out.println("Row duplicates: " + countRowDuplicates(matrix));
            System.out.println("Column duplicates: " + countColumnDuplicates(matrix));
            
            testCases--;
        }
        
        scan.close();
    }
    
    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }
    
    private static int countRowDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        for (int[] row : matrix) {
            if (hasDuplicates(row)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
    
    private static int countColumnDuplicates(int[][] matrix) {
        int duplicateCount = 0;
        for (int col = 0; col < matrix.length; col++) {
            int[] column = new int[matrix.length];
            for (int row = 0; row < matrix.length; row++) {
                column[row] = matrix[row][col];
            }
            if (hasDuplicates(column)) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
    
    private static boolean hasDuplicates(int[] array) {
        boolean[] seen = new boolean[array.length + 1];
        for (int value : array) {
            if (seen[value]) {
                return true;
            }
            seen[value] = true;
        }
        return false;
    }
}