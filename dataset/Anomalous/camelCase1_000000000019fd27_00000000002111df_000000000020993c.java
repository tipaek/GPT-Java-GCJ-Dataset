import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Vestigium {

    static BufferedReader br;
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            boolean[] rowFlags = new boolean[n];
            boolean[] colFlags = new boolean[n];
            boolean[][] rowCheck = new boolean[n][n];
            boolean[][] colCheck = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = nextInt() - 1;
                    if (i == j) {
                        trace += value + 1;
                    }
                    if (rowCheck[i][value] && !rowFlags[i]) {
                        rowRepeats++;
                        rowFlags[i] = true;
                    } else {
                        rowCheck[i][value] = true;
                    }
                    if (colCheck[value][j] && !colFlags[j]) {
                        colRepeats++;
                        colFlags[j] = true;
                    } else {
                        colCheck[value][j] = true;
                    }
                }
            }

            System.out.println("Case #" + caseNumber++ + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException();
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}