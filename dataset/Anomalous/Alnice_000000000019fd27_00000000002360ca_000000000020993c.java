import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCaseCount = scanner.nextInt();
        
        for (int test = 1; test <= testCaseCount; test++) {
            int matrixSize = scanner.nextInt();
            int[] columnXOR = new int[matrixSize];
            int[] rowXOR = new int[matrixSize];
            int trace = 0;
            
            for (int row = 0; row < matrixSize; row++) {
                for (int col = 0; col < matrixSize; col++) {
                    int value = scanner.nextInt();
                    if (row == col) {
                        trace += value;
                    }
                    columnXOR[col] ^= (value ^ (row + 1));
                    rowXOR[row] ^= (value ^ (col + 1));
                }
            }
            
            int duplicateColumns = 0;
            int duplicateRows = 0;
            
            for (int i = 0; i < matrixSize; i++) {
                if (columnXOR[i] != 0) {
                    duplicateColumns++;
                }
                if (rowXOR[i] != 0) {
                    duplicateRows++;
                }
            }
            
            System.out.println("Case #" + test + ": " + trace + " " + duplicateColumns + " " + duplicateRows);
        }
    }
}