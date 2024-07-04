import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            Set<Integer>[] rows = new HashSet[n];
            Set<Integer>[] cols = new HashSet[n];
            boolean[] rowFlags = new boolean[n];
            boolean[] colFlags = new boolean[n];

            for (int i = 0; i < n; i++) {
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
            }

            int trace = 0;
            int numRows = 0;
            int numCols = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int current = scanner.nextInt();

                    if (i == j) {
                        trace += current;
                    }

                    if (!rows[i].add(current) && !rowFlags[i]) {
                        rowFlags[i] = true;
                        numRows++;
                    }

                    if (!cols[j].add(current) && !colFlags[j]) {
                        colFlags[j] = true;
                        numCols++;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + numRows + " " + numCols);
        }

        scanner.close();
    }
}