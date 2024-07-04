import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t1 = Integer.parseInt(in.readLine());

        for (int k = 1; k <= t1; k++) {
            int n = Integer.parseInt(in.readLine());
            int[] j = new int[1441];
            int[] c = new int[1441];
            int[][] a = new int[n][2];

            Arrays.fill(j, 0);
            Arrays.fill(c, 0);

            for (int i = 0; i < n; i++) {
                String[] b = in.readLine().split(" ");
                a[i][0] = Integer.parseInt(b[0]);
                a[i][1] = Integer.parseInt(b[1]);
            }

            StringBuilder ans = new StringBuilder();
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                int start = a[i][0];
                int end = a[i][1];
                boolean jj = false, cc = false;

                for (int m = start + 1; m < end; m++) {
                    if (j[m] == 1) jj = true;
                    if (c[m] == 1) cc = true;
                }

                if (jj && cc) {
                    ans = new StringBuilder("IMPOSSIBLE");
                    impossible = true;
                    break;
                }

                if (!impossible) {
                    if (!jj && cc) {
                        Arrays.fill(j, start, end + 1, 1);
                        ans.append("J");
                    } else if (jj && !cc) {
                        Arrays.fill(c, start, end + 1, 1);
                        ans.append("C");
                    } else { // !jj && !cc
                        Arrays.fill(j, start, end + 1, 1);
                        ans.append("J");
                    }
                }
            }

            if (!impossible) {
                for (int i = 0; i < n; i++) {
                    int start = a[i][0];
                    int end = a[i][1];

                    if (end - start == 1) {
                        if (j[start] == 0 || j[start + 1] == 0) {
                            ans.append("J");
                            j[start] = j[start + 1] = 1;
                        } else if (c[start] == 0 || c[start + 1] == 0) {
                            ans.append("C");
                            c[start] = c[start + 1] = 1;
                        } else {
                            ans = new StringBuilder("IMPOSSIBLE");
                            break;
                        }
                    }
                }
            }

            System.out.println("Case #" + k + ": " + ans.toString().trim());
        }
    }
}