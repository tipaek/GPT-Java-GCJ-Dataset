import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());
            for (int i = 1; i <= T; i++) {
                int N = Integer.parseInt(br.readLine());
                boolean[][] columns = new boolean[N][N];
                boolean[] col = new boolean[N];
                int trace = 0, rowRepeats = 0, colRepeats = 0;

                for (int j = 0; j < N; j++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    boolean[] rows = new boolean[N];
                    boolean rowRepeat = false;

                    for (int k = 0; k < N; k++) {
                        int n = Integer.parseInt(st.nextToken());
                        if (j == k) {
                            trace += n;
                        }
                        if (rows[n - 1]) {
                            rowRepeat = true;
                        }
                        rows[n - 1] = true;

                        if (columns[n - 1][k] && !col[k]) {
                            col[k] = true;
                            colRepeats++;
                        }
                        columns[n - 1][k] = true;
                    }
                    if (rowRepeat) {
                        rowRepeats++;
                    }
                }
                bw.write(String.format("Case #%d: %d %d %d", i, trace, rowRepeats, colRepeats));
                bw.newLine();
            }
            bw.flush();
        }
    }
}