import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static int row[][];
    public static int col[][];
    public static boolean col_flag[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            int N = Integer.parseInt(br.readLine());
            row = new int[N][N + 1];
            col = new int[N][N + 1];
            col_flag = new boolean[N];
            int k, r, c;
            k = r = c = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                boolean row_flag = false;
                for (int j = 0; j < N; j++) {
                    int tmp = Integer.parseInt(st.nextToken());

                    if (i == j)
                        k += tmp;

                    row[i][tmp]++;
                    if (row[i][tmp] > 1 && !row_flag) {
                        r++;
                        row_flag = true;
                    }

                    col[j][tmp]++;

                    if (col[j][tmp] > 1 && !col_flag[j]) {
                        c++;
                        col_flag[j] = true;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", t, k, r, c);
        }
    }
}