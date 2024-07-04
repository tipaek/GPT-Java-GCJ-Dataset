import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    // Method to count repeated elements in columns
    public static int colRepeat(String[][] matrix) {
        int count = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            for (int row1 = 0; row1 < size; row1++) {
                for (int row2 = row1 + 1; row2 < size; row2++) {
                    if (matrix[row1][col].equals(matrix[row2][col])) {
                        count++;
                        row1 = size; // Exit outer loop
                        break; // Exit inner loop
                    }
                }
            }
        }
        return count;
    }

    // Method to count repeated elements in rows
    public static int rowRepeat(String[][] matrix) {
        int count = 0;
        int size = matrix.length;
        for (int row = 0; row < size; row++) {
            for (int col1 = 0; col1 < size; col1++) {
                for (int col2 = col1 + 1; col2 < size; col2++) {
                    if (matrix[row][col1].equals(matrix[row][col2])) {
                        count++;
                        row = size; // Exit outer loop
                        break; // Exit inner loop
                    }
                }
            }
        }
        return count;
    }

    // Method to calculate the trace of the matrix
    public static int trace(String[][] matrix) {
        int traceSum = 0;
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            traceSum += Integer.parseInt(matrix[i][i]);
        }
        return traceSum;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int i = 1; i <= testCases; i++) {
            int matrixSize = Integer.parseInt(reader.readLine());
            String[][] matrix = new String[matrixSize][matrixSize];
            
            for (int j = 0; j < matrixSize; j++) {
                matrix[j] = reader.readLine().split(" ");
            }
            
            int trace = trace(matrix);
            int rowRepeats = rowRepeat(matrix);
            int colRepeats = colRepeat(matrix);
            
            System.out.println("Case #" + i + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}