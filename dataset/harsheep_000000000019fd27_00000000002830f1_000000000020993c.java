import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //scanners
        //Scanner board = new Scanner(
        //  new BufferedReader(new InputStreamReader(System.in)));
        Scanner board = new Scanner(System.in);

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

            // series addition for size (1 - size)
            int ans = 0;
            for (int h = 1; h <= size; h++) {
                ans += h;
            }

            // calc the number of columns with repeats
            int countCol = 0;
            for (int c = 0; c < size; c++) { // 0, 1, 2
                int sumCol = 0;
                for (int cn = c; cn < size * size; cn += size) {
                    sumCol += matrix.get(cn);
                }
                if (sumCol != ans) {
                    countCol++;
                }
            }

            // calc the number of rows with repeats
            int countRow = 0;
            for (int r = 0; r < size * size; r += size) {
                int sumRow = 0;
                for (int rn = r; rn < r + size; rn++) {
                    sumRow += matrix.get(rn);
                }
                if (sumRow != ans) {
                    countRow++;
                }
            }

            // print out the solution
            System.out.println("Case #" + (i + 1) + ": " + trace + " "
                    + countRow + " " + countCol);
        }
    }
}