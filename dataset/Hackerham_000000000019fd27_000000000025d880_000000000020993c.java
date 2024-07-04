import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream("task.in");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OutputStream outputStream;
        try {
            outputStream = new FileOutputStream("task.out");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            out.write("Case #" + testNumber + ": ");

            int N = in.nextInt();
            int[][] a = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    a[i][j] = in.nextInt();
                }
            }

            int k = 0;
            for (int i = 0; i < N; i++) k += a[i][i];

            int r = 0, c = 0;

            int[] found = new int[N];

            cycle:
            for (int i = 0; i < N; i++) {
                Arrays.fill(found, 0);
                for (int j = 0; j < N; j++) {
                    if (found[a[i][j] - 1] > 0) {
                        r++;
                        continue cycle;
                    }
                    found[a[i][j] - 1]++;
                }
            }

            cycle:
            for (int i = 0; i < N; i++) {
                Arrays.fill(found, 0);
                for (int j = 0; j < N; j++) {
                    if (found[a[j][i] - 1] > 0) {
                        c++;
                        continue cycle;
                    }
                    found[a[j][i] - 1]++;
                }
            }

            out.write(k + " " + r + " " + c + "\n");
        }

    }
}

