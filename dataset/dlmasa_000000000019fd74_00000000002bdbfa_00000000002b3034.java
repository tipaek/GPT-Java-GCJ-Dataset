import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.solve();
    }
    public void solve() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scan.nextInt();
        for (int t = 1 ; t <= T; t++) {
            int N = scan.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(scan.next());
            }
            int max_len = list.stream().mapToInt(i -> i.length()).max().getAsInt();
            char[] ans = new char[max_len];
            Arrays.fill(ans, '*');
            boolean impossible = false;
            for (int i = 0; i < N && !impossible; i++) {
                String x = list.get(i);
                char[] d = x.toCharArray();
                int d_len = d.length;
                int len_diff = max_len - d.length;
                for (int j = 0; j < d_len; j++) {
                    if (d[j] == '*') {
                        continue;
                    }
                    if (ans[j + len_diff] == '*') {
                        ans[j + len_diff] = d[j];
                        continue;
                    }
                    if (d[j] != ans[j + len_diff]) {
                        impossible = true;
                        break;
                    }
                }
            }
            if (impossible) {
                System.out.printf("Case #%d: *\n", t);
            } else {
                String y = String.valueOf(ans);
                System.out.printf("Case #%d: %s\n", t, y.substring(1));
            }
        }
    }
}
