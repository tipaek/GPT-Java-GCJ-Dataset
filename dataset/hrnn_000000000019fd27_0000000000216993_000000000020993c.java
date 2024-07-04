import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Hernan
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {

            int cases = in.nextInt();


            for (int test = 1; test <= cases; ++test) {

                int n = in.nextInt();

                Map<Integer, Boolean> map = new HashMap<>();

                int r = 0;
                int c = 0;
                int trace = 0;

                int[][] m = new int[n][n];

                for (int row = 0; row < n; row++) {
                    for (int col = 0; col < n; col++) {
                        m[row][col] = in.nextInt();
                    }

                }

                for (int row = 0; row < n; row++) {

                    boolean rowDuplicates = false;

                    for (int col = 0; col < n; col++) {
                        int item = m[row][col];

                        if (row == col) {
                            trace += item;
                        }

                        if (map.containsKey(item)) {
                            rowDuplicates = true;
                        } else {
                            map.put(item, true);
                        }

                    }
                    map = new HashMap<>();

                    if (rowDuplicates) {
                        r++;
                    }
                }

                for (int row = 0; row < n; row++) {

                    boolean colDuplicates = false;

                    for (int col = 0; col < n; col++) {
                        int item = m[col][row];

                        if (map.containsKey(item)) {
                            colDuplicates = true;
                        } else {
                            map.put(item, true);
                        }

                    }
                    map = new HashMap<>();

                    if (colDuplicates) {
                        c++;
                    }
                }


                System.out.println("Case #" + test + ": " + trace + " " + r + " " + c);

            }


        }

    }
}

