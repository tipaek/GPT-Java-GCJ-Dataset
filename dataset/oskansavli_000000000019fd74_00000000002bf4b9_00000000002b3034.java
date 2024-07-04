
import java.util.*;
import java.io.*;
public class Solution {

    static String[] patterns;
    static String[] p2;
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int ti = 1; ti <= t; ++ti) {
            n = in.nextInt();
            patterns = new String[n];
            p2 = new String[n];
            for (int i=0; i<n; i++) {
                patterns[i] = in.next();
            }

            String result = solve();

            System.out.println("Case #" + ti + ": " + result);
        }
    }

    static String solve() {
        String start = "";
        String end = "";
        for (int i=0; i<n; i++) {
            String str = patterns[i];
            int ind1 = str.indexOf("*");
            int ind2 = str.lastIndexOf("*");
            String s = (ind1 == -1) ? str : str.substring(0,ind1);
            String e = (ind2 == -1) ? str : str.substring(ind2+1);
            if (s.length() > start.length()) {
                // update start to s
                if (s.startsWith(start)) {
                    start = s;
                } else {
                    return "*";
                }
            } else {
                // check s doesn't violate start
                if (!start.startsWith(s)) {
                    return "*";
                }
            }
            if (e.length() > end.length()) {
                // update end to e
                if (e.endsWith(end)) {
                    end = e;
                } else {
                    return "*";
                }
            } else {
                // check e doesn't violate end
                if (!end.endsWith(e)) {
                    return "*";
                }
            }
        }

        // compute trimmed patterns
        for (int i=0; i<n; i++) {
            String str = patterns[i];
            int ind1 = str.indexOf("*");
            int ind2 = str.lastIndexOf("*");
            if (ind1 == -1) {
                p2[i] = "";
            } else {
                p2[i] = str.substring(ind1, ind2+1);
            }
        }

        // concat all chars in simplified patterns
        String mid = "";
        for (int i=0; i<n; i++) {
            String str = p2[i];
            String m = str.replace("*", "");
            mid += m;
        }

        return start + mid + end;
    }
}
