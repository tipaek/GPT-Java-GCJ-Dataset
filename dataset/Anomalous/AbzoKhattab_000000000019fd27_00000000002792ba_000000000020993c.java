import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner();
        int l = sc.nextInt();

        for (int k = 0; k < l; k++) {
            int n = sc.nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            int[][] rows = new int[n][n + 1];
            int[][] cols = new int[n][n + 1];

            for (int i = 0; i < n; i++) {
                boolean traceAdded = false;
                for (int j = 0; j < n; j++) {
                    int value = sc.nextInt();
                    rows[i][value]++;
                    cols[j][value]++;
                    if (i == j && !traceAdded) {
                        trace += value;
                        traceAdded = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (rows[i][j] > 1) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int i = 1; i <= n; i++) {
                    if (cols[j][i] > 1) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (k + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}

class Scanner {
    BufferedReader br;
    StringTokenizer st;

    public Scanner(String s) {
        try {
            br = new BufferedReader(new FileReader(s));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Scanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String nextToken() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }
}