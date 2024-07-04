import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
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

            boolean[] temp = new boolean[d];

            int r = 0;
            for (int i = 0; i < d; i++) {
                Arrays.fill(temp, false);
                for (int j = 0; j < d; j++) {
                    int p = a[i][j] - 1;
                    if (temp[p]) {
                        r++;
                        break;
                    }
                    temp[p] = true;
                }
            }

            int c = 0;
            for (int i = 0; i < d; i++) {
                Arrays.fill(temp, false);
                for (int j = 0; j < d; j++) {
                    int p = a[j][i] - 1;
                    if (temp[p]) {
                        c++;
                        break;
                    }
                    temp[p] = true;
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", cc, k, r, c);
        }

    }

}
