import java.util.Scanner;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int t = 1; t <= testCaseCount; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int[] result = calculateVestigium(matrix);
            System.out.printf("Case #%d: %d %d %d%n", t, result[0], result[1], result[2]);
        }
        
        scanner.close();
    }

    private static int[] calculateVestigium(int[][] matrix) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;
        
        int size = matrix.length;
        boolean[][] rowCheck = new boolean[size][size];
        boolean[][] colCheck = new boolean[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                
                if (rowCheck[i][matrix[i][j] - 1]) {
                    duplicateRows++;
                    break;
                }
                rowCheck[i][matrix[i][j] - 1] = true;
                
                if (colCheck[j][matrix[i][j] - 1]) {
                    duplicateCols++;
                    break;
                }
                colCheck[j][matrix[i][j] - 1] = true;
            }
        }
        
        return new int[]{trace, duplicateRows, duplicateCols};
    }
}