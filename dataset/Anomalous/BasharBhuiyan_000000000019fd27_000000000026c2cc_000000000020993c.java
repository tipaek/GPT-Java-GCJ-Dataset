import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] rowCount = new int[size][size];
            int[][] colCount = new int[size][size];
            int[] colRepetitionFlag = new int[size];
            
            int trace = 0, repeatedRows = 0, repeatedCols = 0;
            
            for (int row = 0; row < size; row++) {
                boolean rowHasRepetition = false;
                for (int col = 0; col < size; col++) {
                    int value = scanner.nextInt();
                    
                    if (row == col) {
                        trace += value;
                    }
                    
                    rowCount[row][value - 1]++;
                    colCount[col][value - 1]++;
                    
                    if (rowCount[row][value - 1] >= 2 && !rowHasRepetition) {
                        repeatedRows++;
                        rowHasRepetition = true;
                    }
                    
                    if (colCount[col][value - 1] >= 2 && colRepetitionFlag[col] != 1) {
                        colRepetitionFlag[col] = 1;
                        repeatedCols++;
                    }
                }
            }
            
            System.out.println("Case #" + testCase + ": " + trace + " " + repeatedRows + " " + repeatedCols);
        }
        
        scanner.close();
    }
}