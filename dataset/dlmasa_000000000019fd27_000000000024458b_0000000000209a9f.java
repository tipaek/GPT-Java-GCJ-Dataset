import java.io.BufferedReader;
import java.io.InputStreamReader;
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
            String S = scan.next();
            char[] d = S.toCharArray();
            int len = d.length;
            StringBuilder ans = new StringBuilder();
            int previous = 0;
            for (int i = 0; i < len; i++) {
                if (0 < (d[i] - '0') - previous) {
                    int l = (d[i] - '0') - previous;
                    for (int j = 0; j < l; j++) {
                        ans.append("(");
                    }
                    previous = d[i] - '0';
                    ans.append(d[i]);
                    continue;
                } else if (0 < previous - (d[i] - '0')){
                    int l = previous - (d[i] - '0');
                    for (int j = 0; j < l; j++) {
                        ans.append(")");
                    }
                    previous = d[i] - '0';
                    ans.append(d[i]);
                } else {
                    previous = d[i] - '0';
                    ans.append(d[i]);
                }
            }
            for (int j = 0; j < previous; j++) {
                ans.append(")");
            }
            System.out.println(ans);
        }
    }
}
