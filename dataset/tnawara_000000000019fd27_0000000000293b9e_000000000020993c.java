import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
3
4
1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
3
2 1 3
1 3 2
1 2 3
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));
        PrintWriter out = new PrintWriter(outputStream);
        int t = in.nextInt();
        for (int i = 0; i < t; ++i) {
            Task solver = new Task();
            solver.solve(i + 1, in, out);
        }
        out.close();

    }

    private static class Task {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            Set<Integer> repeatedRows = new HashSet<>();
            Set<Integer> repeatedCols = new HashSet<>();
            Set<Integer>[] rows = new Set[n];
            Set<Integer>[] cols = new Set[n];
            for (int i = 0; i < n; ++i) {
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
            }
            int sum = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    int x = in.nextInt();
                    if (i == j) {
                        sum += x;
                    }
                    if (rows[i].contains(x)) {
                        repeatedRows.add(i);
                    }
                    if (cols[j].contains(x)) {
                        repeatedCols.add(j);
                    }
                    rows[i].add(x);
                    cols[j].add(x);
                }
            }
            out.printf("Case #%d: %d %d %d\n", testNumber, sum, repeatedRows.size(), repeatedCols.size());
        }
    }
}
