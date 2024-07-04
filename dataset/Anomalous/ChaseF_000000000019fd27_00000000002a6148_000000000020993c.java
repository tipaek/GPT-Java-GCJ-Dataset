import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LatinSquareChecker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read the number of test cases
        int numCases = Integer.parseInt(in.nextLine());

        for (int caseCount = 1; caseCount <= numCases; caseCount++) {
            int k = 0, r = 0, c = 0;

            // Read the size of the matrix (n)
            int n = Integer.parseInt(in.nextLine());

            // Create a map to store the matrix rows
            HashMap<Integer, String> matrix = new HashMap<>();

            for (int rowCount = 1; rowCount <= n; rowCount++) {
                HashSet<Integer> rowCheck = new HashSet<>();
                String rowStr = in.nextLine();
                matrix.put(rowCount, rowStr);

                boolean hasDuplicate = false;
                for (int col = 1; col <= n; col++) {
                    int el = Integer.parseInt(rowStr.substring(2 * col - 2, 2 * col - 1));

                    if (col == rowCount) {
                        // Add to trace
                        k += el;
                    }

                    if (!hasDuplicate && rowCheck.contains(el)) {
                        hasDuplicate = true;
                        r++;
                    }
                    rowCheck.add(el);
                }
            }

            // Check for column duplicates
            for (int i = 1; i <= n; i++) {
                HashSet<Integer> colCheck = new HashSet<>();
                for (int j = 1; j <= n; j++) {
                    int el = Integer.parseInt(matrix.get(j).substring(2 * i - 2, 2 * i - 1));
                    if (colCheck.contains(el)) {
                        c++;
                        break;
                    }
                    colCheck.add(el);
                }
            }

            // Print the result for the current test case
            System.out.println("Case #" + caseCount + ": " + k + " " + r + " " + c);
        }

        in.close();
    }
}