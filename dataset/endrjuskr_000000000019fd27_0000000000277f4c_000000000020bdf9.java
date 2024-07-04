import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            StringBuilder builder = new StringBuilder(N);
            int cors[][] = new int[2 * N][3];
            for(int i = 0; i < N; i++) {
                builder.append('C');
                cors[2 * i][0] = in.nextInt();
                cors[2 * i + 1][0] = in.nextInt();
                cors[2 * i + 1][1] = -1;
                cors[2 * i][1] = cors[2 * i + 1][0];
                cors[2 * i][2] = i;
                cors[2 * i + 1][2] = i;
            }

            Arrays.sort(cors, (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            });

            int c = -1;
            int j = -1;

            for(int i = 0; i < 2 * N; i++) {
                if (cors[i][1] >= 0) {
                    if (c < 0) {
                        builder.setCharAt(cors[i][2], 'C');
                        c = cors[i][1];
                    } else if (j < 0) {
                        builder.setCharAt(cors[i][2], 'J');
                        j = cors[i][1];
                    } else {
                        builder = new StringBuilder();
                        builder.append("IMPOSSIBLE");
                        break;
                    }
                } else {
                    if (c == cors[i][0]) {
                        c = -1;
                    } else {
                        j = -1;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %s", t, builder.toString()));
        }
    }
}
