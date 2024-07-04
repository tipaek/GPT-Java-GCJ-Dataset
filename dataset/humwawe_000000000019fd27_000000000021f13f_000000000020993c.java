import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author hum
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        String result = "Case #%d: %s %s %d";
        for (int i = 1; i <= n; i++) {
            int len = sc.nextInt();
            int sum = 0;
            int r = 0;
            int c = 0;
            boolean[][] row = new boolean[len][len];
            boolean[][] col = new boolean[len][len];
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    int tmp = sc.nextInt();
                    if (j == k) {
                        sum += tmp;
                    }
                    row[j][tmp - 1] = true;
                    col[k][tmp - 1] = true;
                }
            }
            for (int j = 0; j < len; j++) {
                boolean f1 = false;
                boolean f2 = false;
                for (int k = 0; k < len; k++) {
                    if (!row[j][k]) {
                        f1 = true;
                    }
                    if (!col[j][k]) {
                        f2 = true;
                    }
                }
                if (f1) {
                    r++;
                }
                if (f2) {
                    c++;
                }
            }
            System.out.println(String.format(result, i, sum, r, c));
        }
    }
}
