import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintWriter writer = new PrintWriter(System.out);
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            writer.printf("Case #%d: ", i);
            solution.solve();
        }
        writer.flush();
        System.exit(0);
    }

    private void solve() throws IOException {
        int n = scanner.nextInt();
        Set<Integer>[] rows = new HashSet[n];
        Set<Integer>[] cols = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }

        int trace = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int current = scanner.nextInt();
                if (i == j) {
                    trace += current;
                }
                rows[i].add(current);
                cols[j].add(current);
            }
        }

        int rowDuplicates = 0;
        int colDuplicates = 0;
        for (int i = 0; i < n; i++) {
            if (rows[i].size() != n) {
                rowDuplicates++;
            }
            if (cols[i].size() != n) {
                colDuplicates++;
            }
        }

        writer.printf("%d %d %d%n", trace, rowDuplicates, colDuplicates);
    }
}