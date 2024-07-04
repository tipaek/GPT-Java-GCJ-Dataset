import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder ans = new StringBuilder();

        for (int x = 1; x <= t; x++) {
            int n = sc.nextInt();
            int[] s = new int[n];
            int[] e = new int[n];

            for (int nn = 0; nn < n; nn++) {
                s[nn] = sc.nextInt();
                e[nn] = sc.nextInt();
            }

            String y = assignTasks(n, s, e);

            if (x != t) {
                ans.append("Case #").append(x).append(": ").append(y).append("\n");
            } else {
                ans.append("Case #").append(x).append(": ").append(y);
            }
        }

        System.out.print(ans.toString());
        sc.close();
    }

    private static String assignTasks(int n, int[] s, int[] e) {
        int cs = -1, ce = -1, js = -1, je = -1;
        StringBuilder y = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (ce <= s[i] || cs >= e[i]) {
                y.append("C");
                if (cs == -1) {
                    cs = s[i];
                    ce = e[i];
                } else {
                    cs = Math.min(cs, s[i]);
                    ce = Math.max(ce, e[i]);
                }
            } else if (je <= s[i] || js >= e[i]) {
                y.append("J");
                if (js == -1) {
                    js = s[i];
                    je = e[i];
                } else {
                    js = Math.min(js, s[i]);
                    je = Math.max(je, e[i]);
                }
            } else {
                return "IMPOSSIBLE";
            }
        }
        return y.toString();
    }
}