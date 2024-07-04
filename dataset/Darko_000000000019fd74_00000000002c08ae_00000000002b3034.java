import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    class Blah {
        String s1, s2;

        Blah(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
    }

    private void work() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nc = sc.nextInt();
        for (int tc = 1; tc <= nc; tc++) {
            int n = sc.nextInt();
            List<Blah> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                if (s.charAt(0) == '*') {
                    a.add(new Blah("", s.substring(1)));
                } else if (s.charAt(s.length() - 1) == '*') {
                    a.add(new Blah(s.substring(0, s.length() - 1), ""));
                } else {
                    String[] spl = s.split("\\*");
                    a.add(new Blah(spl[0], spl[1]));
                }
            }

            a.sort(Comparator.comparingInt(o -> o.s1.length()));

            boolean ok = true;
            for (int i = 1; i < a.size(); i++) ok &= a.get(i).s1.startsWith(a.get(i - 1).s1);
            String ans = ok ? a.get(a.size() - 1).s1 : "*";

            if (ok) {
                a.sort(Comparator.comparingInt(o -> o.s2.length()));
                for (int i = 1; i < a.size(); i++) ok &= a.get(i).s2.endsWith(a.get(i - 1).s2);
                ans = ok ? ans + a.get(a.size() - 1).s2 : "*";
            }

            System.out.printf("Case #%d: %s\n", tc, ans);
        }
        sc.close();
    }

    public static void main(String[] args) {
        new Solution().work();
    }
}
