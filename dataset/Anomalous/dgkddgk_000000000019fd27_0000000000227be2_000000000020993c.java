import java.util.Scanner;
import java.util.TreeSet;

class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] transposedMatrix = new int[matrixSize][matrixSize];
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                    transposedMatrix[j][i] = matrix[i][j];
                }
            }
            
            int diagonalSum = 0;
            int duplicateRows = 0;
            int duplicateColumns = 0;
            
            TreeSet<Integer> rowSet = new TreeSet<>();
            TreeSet<Integer> colSet = new TreeSet<>();
            
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    if (i == j) {
                        diagonalSum += matrix[i][j];
                    }
                    rowSet.add(matrix[i][j]);
                    colSet.add(transposedMatrix[i][j]);
                }
                
                if (rowSet.size() != matrixSize) {
                    duplicateRows++;
                }
                if (colSet.size() != matrixSize) {
                    duplicateColumns++;
                }
                
                rowSet.clear();
                colSet.clear();
            }
            
            output.append("Case #").append(t + 1).append(": ")
                  .append(diagonalSum).append(" ")
                  .append(duplicateRows).append(" ")
                  .append(duplicateColumns).append("\n");
        }
        
        System.out.print(output.toString());
    }
}