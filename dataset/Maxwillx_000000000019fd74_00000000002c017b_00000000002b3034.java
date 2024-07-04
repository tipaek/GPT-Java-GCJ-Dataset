import java.util.*;
class Solution {
    public static void main(String[] arg) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        int testCnt = 0;
        String line = sc.nextLine();
        testCnt = Integer.parseInt(line);
        for (int i = 0; i < testCnt; i++) {
            int pcnt = Integer.parseInt(sc.nextLine());
            List<String> ps = new ArrayList<>();
            while (pcnt-- > 0) ps.add(sc.nextLine());
            s.solve(ps, i + 1);
        }
    }
    private void solve(List<String> patterns, int id) {
        String prefix = null, suffix = null;
        StringBuilder mid = new StringBuilder();
        int[] p = new int[2];
        for (String str : patterns) {
            String curp = prefix(str, p), curs = suffix(str, p);
            if (prefix == null) prefix = curp;
            else {
                if (!match(prefix, curp)) {
                    print("*", id);
                    return;
                }
                if (curp.length() > prefix.length()) prefix = curp;
            }
            if (suffix == null) suffix = curs;
            else {
                if (!smatch(suffix, curs)) {
                    print("*", id);
                    return;
                }
                if (curs.length() > suffix.length()) suffix = curs;
            }
            StringBuilder curm = mid(str, p);
            mid.append(curm);
        }
        print(prefix + mid.toString() + suffix, id);
        return;
    }
    private String prefix(String str, int[] p) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*') {
                p[0] = i;
                return str.substring(0, i);
            }
        }
        return null;
    }
    private String suffix(String str, int[] p) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '*') {
                p[1] = i;
                return str.substring(i + 1);
            }
        }
        return null;
    }
    private StringBuilder mid(String str, int[] p) {
        StringBuilder sb = new StringBuilder();
        for (int i = p[0]; i <= p[1]; i++) {
            if (str.charAt(i) != '*') sb.append(str.charAt(i));
        }
        return sb;
    }
    private boolean match(String prefix, String cur) {
        for (int i = 0; i < prefix.length(); i++) {
            if (i >= cur.length()) return true;
            if (prefix.charAt(i) != cur.charAt(i)) return false;
        }
        return true;
    }
    private boolean smatch(String suffix, String cur) {
        for (int i = 0; i < suffix.length(); i++) {
            if (cur.length() - 1 - i < 0) return true;
            if (suffix.charAt(suffix.length() - 1 - i) !=
                    cur.charAt(cur.length() - 1 - i)) return false;
        }
        return true;
    }
    private void print(String res, int id) {
        System.out.print("Case #" + Integer.toString(id) + ": ");
        System.out.println(res);
    }
}