import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //scanners
        Scanner board = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        //Scanner board = new Scanner(System.in);

        // number of test cases
        int n = board.nextInt(); // scnr has f(n) to read ints, strings, etc.

        // size of matrix
        int size = 0;
        // number of matrices to run the code
        for (int i = 0; i < n; i++) {
            size = board.nextInt();
            List<Integer> matrix = new ArrayList(0);
            for (int k = 0; k < size * size; k++) {
                matrix.add(board.nextInt());
            }

            // calulate the trace
            int trace = 0;
            for (int l = 0; l < size * size; l += (size + 1)) {
                trace += matrix.get(l);
            }

            // calc the number of columns with repeats
            boolean col = false;
            int countCol = 0;
            for (int n1 = 0; n1 < size; n1++) {
                for (int g = n1; g < size * size - size; g += size) {
                    if (matrix.get(g + size) == matrix.get(g)) {
                        col = true;
                    }
                }
                if (col) {
                    countCol++;
                }
                col = false;
            }

            // calc the number of rows with repeats
            boolean row = false;
            int countRow = 0;
            for (int n1 = 0; n1 < size; n1++) {
                for (int g = n1; g < n1 + size - 1; g++) {
                    if (matrix.get(g + 1) == matrix.get(g)) {
                        row = true;
                    }
                }
                if (row) {
                    countRow++;
                }
                row = false;
            }

            // print out the solution
            System.out.println("Case #" + (i + 1) + ": " + trace + " "
                    + countCol + " " + countRow);
        }
    }
}