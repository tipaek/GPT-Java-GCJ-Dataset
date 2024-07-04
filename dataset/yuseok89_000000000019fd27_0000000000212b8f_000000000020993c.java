import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();

        for (int test = 1; test <= T; ++test) {
            int N = in.nextInt();
            boolean[][] VR = new boolean [N][N + 1];
            boolean[][] VC = new boolean [N][N + 1];
            int k = 0;
            int r = 0;
            int c = 0;

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    int num = in.nextInt();

                    if (i == j) {
                        k += num;
                    }
                    if (VR[i][num]) {
                        if (!VR[i][0]) {
                            ++r;
                        }
                        VR[i][0] = true;
                    }
                    if (VC[j][num]) {
                        if (!VC[j][0]) {
                            ++c;
                        }
                        VC[j][0] = true;
                    }

                    VR[i][num] = VC[j][num] = true;
                }
            }

            System.out.println("Case #" + test + ": " + k + " " + r + " " +  c);
        }
    }
}

