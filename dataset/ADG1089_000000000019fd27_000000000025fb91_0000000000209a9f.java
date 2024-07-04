import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int x = 1; x <= t; x++) {
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (char c : s.toCharArray()) {
                int cc = c - '0';
                while (cc > cnt) {
                    sb.append("(");
                    cnt++;
                }
                while (cc < cnt) {
                    sb.append(")");
                    cnt--;
                }
                sb.append(c);
            }
            while (cnt > 0) {
                sb.append(")");
                cnt--;
            }
            while (cnt < 0) {
                sb.append("(");
                cnt++;
            }
            System.out.printf("Case #%d: %s\n", x, sb.toString());
        }
    }
}