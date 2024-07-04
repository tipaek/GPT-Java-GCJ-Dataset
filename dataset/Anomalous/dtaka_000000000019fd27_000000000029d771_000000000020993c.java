import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(stdin.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(stdin.readLine());

            int k = 0, r = 0, c = 0;
            boolean[] rowFlags = new boolean[N];
            boolean[] colFlags = new boolean[N];
            boolean[][] colValues = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String[] values = stdin.readLine().split(" ");
                boolean[] rowValues = new boolean[N];

                for (int j = 0; j < N; j++) {
                    int value = Integer.parseInt(values[j]) - 1;

                    if (rowValues[value]) rowFlags[i] = true;
                    if (colValues[j][value]) colFlags[j] = true;

                    rowValues[value] = true;
                    colValues[j][value] = true;

                    if (i == j) {
                        k += value + 1;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                if (rowFlags[i]) r++;
                if (colFlags[i]) c++;
            }

            System.out.printf("Case #%d: %d %d %d\n", t, k, r, c);
        }
    }
}