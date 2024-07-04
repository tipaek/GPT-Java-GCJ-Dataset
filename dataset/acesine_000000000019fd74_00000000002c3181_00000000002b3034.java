
import java.util.*;

public class Solution {
    Scanner in = new Scanner(System.in);

    boolean solve0(int t) {
        int n = in.nextInt();
        String[] patterns = new String[n];
        for (int i=0;i<n;i++) patterns[i] = in.next();
        StringBuilder ret = new StringBuilder();
        if (!solveP(patterns, n, ret)) return false;

        System.out.println(String.format("Case #%d: %s", t, ret.reverse().toString()));
        return true;
    }

    boolean solveP(String[] patterns, int n, StringBuilder ret) {
        int[] pos = new int[n];
        for (int i=0;i<n;i++) pos[i] = patterns[i].length()-1;
        while (true) {
            Character m = null;
            boolean done = true;
            for (int i=0;i<n;i++) {
                String p = patterns[i];
                if (pos[i] == 0) continue;
                char c = p.charAt(pos[i]--);
                if (m == null) {
                    m = c;
                    ret.append(c);
                } else if (m != c) return false;
                done = false;
            }
            if (done) break;
        }
        return true;
    }

    boolean solve1(int t) {
        int n = in.nextInt();
        String[] patterns = new String[n];
        for (int i=0;i<n;i++) patterns[i] = in.next();
        StringBuilder ret = new StringBuilder();
        int[] pos = new int[n];
        while (true) {
            boolean done = true;
            Character m = null;
            for (int i=0;i<n;i++) {
                String p = patterns[i];
                char c = p.charAt(pos[i]);
                if (c == '*') continue;
                pos[i]++;
                if (m == null) {
                    m = c;
                    ret.append(c);
                }
                else if (m != c) return false;
                done = false;
            }
            if (done) break;
        }

        StringBuilder suffix = new StringBuilder();
        String[] pts = new String[n];
        for (int i=0;i<n;i++) pts[i] = patterns[i].substring(pos[i], patterns[i].length());

        if (!solveP(pts, n, suffix)) return false;

        ret.append(suffix.reverse().toString());

        System.out.println(String.format("Case #%d: %s", t, ret.toString()));
        return true;
    }

    void run() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) {
            if (!solve1(t)) System.out.println(String.format("Case #%d: *", t));
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
