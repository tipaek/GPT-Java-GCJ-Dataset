import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();
        
        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            int matrixSize = scanner.nextInt();
            boolean[][] rowCheck = new boolean[matrixSize][matrixSize + 1];
            boolean[][] colCheck = new boolean[matrixSize][matrixSize + 1];
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    int value = scanner.nextInt();
                    
                    if (i == j) {
                        trace += value;
                    }
                    
                    if (rowCheck[i][value]) {
                        rowRepeats++;
                        rowCheck[i][value] = false; // Reset to avoid multiple counts for the same row
                    } else {
                        rowCheck[i][value] = true;
                    }
                    
                    if (colCheck[j][value]) {
                        colRepeats++;
                        colCheck[j][value] = false; // Reset to avoid multiple counts for the same column
                    } else {
                        colCheck[j][value] = true;
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}