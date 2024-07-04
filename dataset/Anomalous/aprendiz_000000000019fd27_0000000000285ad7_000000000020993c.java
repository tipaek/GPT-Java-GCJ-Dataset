import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        short T = input.nextShort(); // Number of cases
        
        for (short i = 1; i <= T; ++i) {
            short N = input.nextShort(); // Size of matrix
            short k = 0; // Trace
            short r = 0; // Rows with repeated numbers
            short c = 0; // Columns with repeated numbers

            short[][] matrix = new short[N][N];

            // Read matrix and calculate trace
            for (short row = 0; row < N; row++) {
                boolean hasRepeatedRow = false;
                Set<Short> rowSet = new HashSet<>();
                for (short col = 0; col < N; col++) {
                    matrix[row][col] = input.nextShort();
                    if (row == col) {
                        k += matrix[row][col];
                    }
                    if (!hasRepeatedRow && !rowSet.add(matrix[row][col])) {
                        r++;
                        hasRepeatedRow = true;
                    }
                }
            }

            // Check for repeated columns
            for (short col = 0; col < N; col++) {
                boolean hasRepeatedCol = false;
                Set<Short> colSet = new HashSet<>();
                for (short row = 0; row < N; row++) {
                    if (!hasRepeatedCol && !colSet.add(matrix[row][col])) {
                        c++;
                        hasRepeatedCol = true;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}