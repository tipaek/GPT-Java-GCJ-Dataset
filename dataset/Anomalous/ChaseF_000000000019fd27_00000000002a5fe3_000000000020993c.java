import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

public class LatinSquareChecker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, String> matrixRows = new HashMap<>();

        int numCases = Integer.parseInt(in.nextLine());

        for (int caseCount = 1; caseCount <= numCases; caseCount++) {
            int k = 0, r = 0, c = 0;

            int n = Integer.parseInt(in.nextLine());
            int rowCount = n;

            for (int row = 1; row <= rowCount; row++) {
                HashSet<Integer> rowCheck = new HashSet<>();
                String rowStr = in.nextLine();
                matrixRows.put(row, rowStr);

                boolean hasDuplicateInRow = false;

                for (int col = 1; col <= n; col++) {
                    int el = Integer.parseInt(rowStr.substring(2 * col - 2, 2 * col - 1));

                    if (col == row) {
                        k += el;
                    }
                    if (!hasDuplicateInRow && rowCheck.contains(el)) {
                        hasDuplicateInRow = true;
                        r++;
                    }
                    rowCheck.add(el);
                }
            }

            for (int col = 1; col <= n; col++) {
                HashSet<Integer> colCheck = new HashSet<>();
                for (int row = 1; row <= n; row++) {
                    int el = Integer.parseInt(matrixRows.get(row).substring(2 * col - 2, 2 * col - 1));
                    if (colCheck.contains(el)) {
                        c++;
                        break;
                    }
                    colCheck.add(el);
                }
            }

            System.out.println("Case #" + caseCount + ": " + k + " " + r + " " + c);
        }
    }
}