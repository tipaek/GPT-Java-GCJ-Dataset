import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        
        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int matrixSize = scanner.nextInt();
            boolean[][] rowTracker = new boolean[matrixSize][matrixSize + 1];
            boolean[][] colTracker = new boolean[matrixSize][matrixSize + 1];
            int diagonalSum = 0, rowRepeats = 0, colRepeats = 0;
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    
                    if (row == col) {
                        diagonalSum += value;
                    }
                    
                    if (rowTracker[row][value]) {
                        rowRepeats++;
                        // Reset rowTracker to avoid multiple counts for the same row
                        for (int i = 0; i < matrixSize + 1; i++) {
                            rowTracker[row][i] = false;
                        }
                    } else {
                        rowTracker[row][value] = true;
                    }
                    
                    if (colTracker[col][value]) {
                        colRepeats++;
                        // Reset colTracker to avoid multiple counts for the same column
                        for (int i = 0; i < matrixSize + 1; i++) {
                            colTracker[col][i] = false;
                        }
                    } else {
                        colTracker[col][value] = true;
                    }
                }
            }
            
            int caseNumber = testIndex + 1;
            System.out.println("Case #" + caseNumber + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }
        
        scanner.close();
    }
}