import java.util.Scanner;

public class MatrixAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int matrixSize = scanner.nextInt();
            int[][] rowTracker = new int[matrixSize + 1][matrixSize + 1];
            int[][] colTracker = new int[matrixSize + 1][matrixSize + 1];
            boolean[] colDuplicateCheck = new boolean[matrixSize];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;
            boolean rowDuplicateFlag = false;

            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    
                    if (row == col) {
                        trace += value;
                    }
                    
                    rowTracker[row][value]++;
                    colTracker[col][value]++;
                    
                    if (!rowDuplicateFlag && rowTracker[row][value] > 1) {
                        duplicateRows++;
                        rowDuplicateFlag = true;
                    }
                    
                    if (!colDuplicateCheck[col] && colTracker[col][value] > 1) {
                        duplicateCols++;
                        colDuplicateCheck[col] = true;
                    }
                }
                rowDuplicateFlag = false;
            }
            
            System.out.println("case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}