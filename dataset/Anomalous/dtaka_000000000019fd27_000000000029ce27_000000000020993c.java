import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(stdin.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(stdin.readLine());
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            boolean[] rowFlags = new boolean[N];
            boolean[] colFlags = new boolean[N];
            boolean[][] colUniqueCheck = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String[] values = stdin.readLine().split(" ");
                boolean[] rowUniqueCheck = new boolean[N];

                for (int j = 0; j < N; j++) {
                    int value = Integer.parseInt(values[j]) - 1;

                    if (rowUniqueCheck[value]) rowFlags[i] = true;
                    if (colUniqueCheck[j][value]) colFlags[j] = true;

                    rowUniqueCheck[value] = true;
                    colUniqueCheck[j][value] = true;

                    if (i == j) trace += value + 1;
                }
            }

            for (int i = 0; i < N; i++) {
                if (rowFlags[i]) rowRepeats++;
                if (colFlags[i]) colRepeats++;
            }

            System.out.printf("Case #%d: %d %d %d\n", t, trace, rowRepeats, colRepeats);
        }
    }
}