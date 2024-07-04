import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public  static void  main(String[]  args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testNum = scanner.nextInt();
        for (int i = 0; i < testNum; i++)  {
            solve(scanner, i);
        }
    }

    private static void solve(Scanner scanner, int testNum) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        int trace = 0;
        int repeatedColumns = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> numsInColumn = new HashSet<>();
            boolean isUnique = true;

            for (int j = 0; j < n; j++) {
                int next = scanner.nextInt();
                matrix[i][j] = next;

                if (numsInColumn.contains(next)) {
                    isUnique = false;
                }
                numsInColumn.add(next);

                if (i == j) {
                    trace += next;
                }
            }
            if (!isUnique) {
                repeatedColumns++;
            }
        }

        int repeatedRows = getRepeatedRows(n, matrix);

        System.out.print("Case #" + (testNum + 1) +  ": ");
        System.out.print(trace + " " + repeatedRows + " " + repeatedColumns);
        System.out.println("");
    }

    private static int getRepeatedRows(int n, int[][] matrix) {
        int repeatedRows = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> numsInRow = new HashSet<>();
            boolean isUnique = true;

            for (int j = 0; j < n; j++) {
                int next = matrix[j][i];

                if (numsInRow.contains(next)) {
                    isUnique = false;
                }
                numsInRow.add(next);
            }
            if (!isUnique) {
                repeatedRows++;
            }
        }
        return repeatedRows;
    }
}
