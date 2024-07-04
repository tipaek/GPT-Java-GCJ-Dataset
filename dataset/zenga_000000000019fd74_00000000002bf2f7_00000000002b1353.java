import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int[][] pascal = new int[500][500];

            pascal[0][0] = 1;
            pascal[0][1] = 1;
            pascal[1][1] = 1;
            for (int i = 0; i < 500; i++) {
                pascal[i][0] = 1;
            }

            long remaining = Long.parseLong(br.readLine());

            int r = -1;
            int k = -1;

            System.out.printf("Case #%d: ", t);

            while (remaining > 0) {
                r++;
                if (k < 1) {
                    k++;
                }

                if (r > 1 && k == 1) {
                    pascal[r][k] = pascal[r - 1][k] + 1;
                }

                boolean readjust = false;

                if (remaining < pascal[r][k]) {
                    readjust = true;
                    r--;
                    k = 0;
                }

                remaining -= pascal[r][k];

                System.out.printf("%d %d\n", r + 1, k + 1);

                if (readjust) {
                    r++;
                }

            }

        }

    }
}