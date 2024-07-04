import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private void work() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = sc.nextInt();
        for (int tc = 1; tc <= nc; tc++) {
            char[] s = ("0" + sc.next() + "0").toCharArray();
            StringBuilder sb = new StringBuilder();
            int open = 0;
            for (int i = 0; i < s.length; i++) {
                int val = s[i] - '0';
                while (open < val) {
                    sb.append('(');
                    open++;
                }
                while (open > val) {
                    sb.append(')');
                    open--;
                }
                sb.append(s[i]);
            }

            String out = sb.toString();
            System.out.printf("Case #%d: %s\n", tc, out.substring(1, out.length() - 1));
        }
        sc.close();
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}
