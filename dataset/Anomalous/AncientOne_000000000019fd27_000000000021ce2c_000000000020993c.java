import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            int[][] matrixCopy = new int[size][size];
            int duplicateRows = 0, duplicateColumns = 0, trace = 0;
            
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = scanner.nextInt();
                    matrixCopy[row][col] = matrix[row][col];
                    if (row == col) {
                        trace += matrix[row][col];
                    }
                }
            }
            
            for (int row = 0; row < size; row++) {
                boolean[] seen = new boolean[size];
                for (int col = 0; col < size; col++) {
                    int value = matrix[row][col] - 1;
                    if (seen[value]) {
                        duplicateRows++;
                        break;
                    }
                    seen[value] = true;
                }
            }
            
            for (int col = 0; col < size; col++) {
                boolean[] seen = new boolean[size];
                for (int row = 0; row < size; row++) {
                    int value = matrixCopy[row][col] - 1;
                    if (seen[value]) {
                        duplicateColumns++;
                        break;
                    }
                    seen[value] = true;
                }
            }
            
            System.out.println("Case #" + caseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
        }
        
        scanner.close();
    }
}