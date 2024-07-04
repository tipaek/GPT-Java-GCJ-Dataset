import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());
        for (int cc = 0; cc < cases; cc++) {
            int d = Integer.parseInt(reader.readLine());
            int[][] a = new int[d][d];
            for (int i = 0; i < d; i++) {
                String[] s = reader.readLine().split(" ");
                for (int j = 0; j < s.length; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }

            int k = 0;
            for (int i = 0; i < d; i++) {
                k += a[i][i];
            }

            Set<Integer> temp = new HashSet<>(d);

            int r = 0;
            for (int i = 0; i < d; i++) {
                temp.clear();
                for (int j = 0; j < d; j++) {
                    int p = a[i][j] - 1;
                    if (temp.contains(p)) {
                        r++;
                        break;
                    }
                    temp.add(p);
                }
            }

            int c = 0;
            for (int i = 0; i < d; i++) {
                temp.clear();
                for (int j = 0; j < d; j++) {
                    int p = a[j][i] - 1;
                    if (temp.contains(p)) {
                        c++;
                        break;
                    }
                    temp.add(p);
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", cc + 1, k, r, c);
        }
    }

}
