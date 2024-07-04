import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();

        for(int tc = 1; tc <= t; tc++) {
            int n = in.nextInt();

            int [][] matrix = new int[n][n];
            int duplicatedRows = 0;
            int duplicatedColumns = 0;
            int trace = 0;

            Set<Integer> uniqueSet = null;

            // Go through rows
            for (int r = 0; r < n; r++) {
                uniqueSet = new HashSet<>();

                for (int c = 0; c < n; c++) {
                    int element = in.nextInt();
                    matrix[r][c] = element;

                    uniqueSet.add(element);

                    if (r == c) {
                        trace += element;
                    }
                }

                if (uniqueSet.size() < n) {
                    duplicatedRows++;
                }
            }

            // Go through columns
            for (int c = 0; c < n; c++) {
                uniqueSet = new HashSet<>();
                for (int r = 0; r < n; r++) {
                    uniqueSet.add(matrix[r][c]);
                }

                if (uniqueSet.size() < n) {
                    duplicatedColumns++;
                }
            }

            System.out.println("Case #" + tc + ": " + trace + " " + duplicatedRows + " " + duplicatedColumns);
        }
    }
}
