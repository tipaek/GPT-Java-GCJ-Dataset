import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            boolean[][] rowHas = new boolean[n][n];
            boolean[][] colHas = new boolean[n][n];
            boolean[] rowDup = new boolean[n];
            boolean[] colDup = new boolean[n];
            int rowCount = 0;
            int colCount = 0;
            int trace = 0;

            for (int r = 0; r < n; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) {
                    int e = Integer.parseInt(st.nextToken()) - 1;

                    if (!rowDup[r] && rowHas[r][e]) {
                        rowDup[r] = true;
                        rowCount++;
                    }
                    rowHas[r][e] = true;

                    if (!colDup[c] && colHas[c][e]) {
                        colDup[c] = true;
                        colCount++;
                    }
                    colHas[c][e] = true;

                    if (r == c) {
                        trace += e + 1;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", i + 1, trace, rowCount, colCount);
        }
    }
}