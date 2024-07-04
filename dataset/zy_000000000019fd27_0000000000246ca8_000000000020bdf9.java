
import java.io.*;
import java.util.*;
import java.util.Comparator;


class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(bufferedReader);
        int n = in.nextInt();
        int i = 0, k = 0;
        for (k = 0; k < n; k++) {
            StringBuilder out = new StringBuilder();
            boolean possible = true;
            int cind = -1;
            int jind = -1;
            int num = in.nextInt();
            int[][] acts = new int[num][2];
            for (i = 0; i < num; i++) {
                acts[i][0] = in.nextInt();
                acts[i][1] = in.nextInt();
            }
            Arrays.sort(acts, Comparator.comparingInt(o -> o[0]));
            for (i = 0; i < num; i++) {
                int current = acts[i][0];

                if (cind == -1 || acts[cind][1] <= current) {
                    out.append("C");
                    cind = i;

                } else if (jind == -1 || acts[jind][1] <= current) {
                    out.append("J");
                    jind = i;
                } else {
                    possible = false;
                    break;
                }

            }
            if (possible) {
                System.out.println("Case #" + (k + 1) + ": " + out);
            } else {
                System.out.println("Case #" + (k + 1) + ": IMPOSSIBLE");
            }

        }
    }
}