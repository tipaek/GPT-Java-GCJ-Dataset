//package C2020.Qualification.D;

import java.util.*;

/**
 * Created by Acesine on 4/3/20.
 */
public class Solution {
    Scanner in = new Scanner(System.in);

    void trans1(StringBuilder B) {
        for (int i=0;i<B.length();i++) {
            if (B.charAt(i) == 'x') continue;
            B.setCharAt(i, B.charAt(i) == '0' ? '1' : '0');
        }
    }

    void trans2(StringBuilder B) {
        int p = 0, q = B.length()-1;
        while (p < q) {
            char t = B.charAt(p);
            B.setCharAt(p, B.charAt(q));
            B.setCharAt(q, t);
            p++; q--;
        }
    }

    void transform(Map<String, String> p) {
        HashMap<String, String> prev = new HashMap<>(p);
        p.clear();
        for (String k : prev.keySet()) {
            StringBuilder sb = new StringBuilder(prev.get(k));
            sb.append('0');
            p.put(k, sb.toString());
            StringBuilder b1 = new StringBuilder(k);
            trans1(b1);
            sb.setCharAt(sb.length()-1, '1');
            p.put(b1.toString(), sb.toString());

            StringBuilder b2 = new StringBuilder(k);
            trans2(b2);
            sb.setCharAt(sb.length()-1, '2');
            p.put(b2.toString(), sb.toString());

            StringBuilder b3 = new StringBuilder(k);
            trans1(b3);
            trans2(b3);
            sb.setCharAt(sb.length()-1, '3');
            p.put(b3.toString(), sb.toString());
        }
    }

    boolean isGood(Map<String, String> p) {
        if (p.size() != 1) return false;
        String s = p.keySet().iterator().next();
        for (int i=0;i<s.length();i++) if (s.charAt(i) == 'x') return false;
        return true;
    }

    int select(Set<String> p) {
        List<String> l = new ArrayList<>(p);
        int n = l.get(0).length();
        int minDiffLoc = -1;
        int diff = 1000;
        int maxUnknownLoc = -1;
        int unknown = 0;
        for (int i=0;i<n;i++) {
            int ones = 0;
            int zeros = 0;
            int x = 0;
            for (int j=0;j<l.size();j++) {
                char c = l.get(j).charAt(i);
                ones += c == '1' ? 1 : 0;
                zeros += c == '0' ? 1 : 0;
                x += c == 'x' ? 1 : 0;
            }
            if (ones != 0 && zeros != 0 && Math.abs(ones - zeros) < diff) {
                diff = Math.abs(ones - zeros);
                minDiffLoc = i;
            }
            if (x > unknown) {
                unknown = x;
                maxUnknownLoc = i;
            }
        }
        if (minDiffLoc != -1) return minDiffLoc;
        return maxUnknownLoc;
    }

    void solve() {
        int t = in.nextInt();
        int b = in.nextInt();
        while (t-- > 0) {
            StringBuilder debug = new StringBuilder();
            debug.append("DEUBG: \n");
            Map<String, String> p = new TreeMap<>();
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<b;i++) sb.append('x');
            p.put(sb.toString(), "0");
            int i = 0;
            while (i<150) {
                if (isGood(p)) break;
                if (i > 0 && i % 10 == 0) {
                    transform(p);
                }
                int sel = i < b? i % b : select(p.keySet());
                System.out.println(sel+1);
                char v = (char) ('0' + in.nextInt());
                debug.append(i + ": " + sel + ": " + v).append("\n");

                Map<String, String> l = new HashMap<>(p);
                p.clear();
                for (String s : l.keySet()) {
                    if (s.charAt(sel) != 'x' && s.charAt(sel) != v) continue;
                    StringBuilder newKey = new StringBuilder(s);
                    newKey.setCharAt(sel, v);
                    p.put(newKey.toString(), l.get(s));
                }
                debug.append("=====\n");
                for (String ss : p.keySet()) debug.append(ss + " : " + p.get(ss)).append("\n");
                debug.append("=====\n");
                i++;
            }
            System.out.println(p.keySet().iterator().next());
            debug.append("=====\n");
            for (String ss : p.keySet()) debug.append(ss).append("\n");
            debug.append("=====\n");
            if (!in.next().equals("Y")) throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        new Solution().solve();
    }
}
