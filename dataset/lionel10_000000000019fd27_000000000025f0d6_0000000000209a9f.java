import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        for (int t = 1; t <= T; t++) {
            String s = scan.nextLine();
            int n = s.length();
            System.out.println("Case #" + t + ": " + solve(s, n));
        }
    }
    static String solve(String s, int n) {
        String ans = "";
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - 48;
            if (num == cnt) ans += num;
            else if (num > cnt) {
                for (int j = 0; j < num - cnt; j++) ans += "(";
                ans += num; cnt = num;
            }else {
                for (int j = 0; j < cnt - num; j++) ans += ")";
                ans += num; cnt = num;
            }
        }
        while (cnt-- > 0) ans += ")";
        return ans;
    }
}
