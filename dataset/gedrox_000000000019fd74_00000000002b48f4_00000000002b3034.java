import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            boolean ok = true;
            boolean fixed = false;
            String fixedStr = null;

            String s = "";
            String e = "";
            StringBuilder mid = new StringBuilder("");

            int n = sc.nextInt();
            int read = 0;
            for (int i1 = 0; i1 < n; i1++) {
                String p = sc.next();
                read++;

                if (p.equals("*")) {
                    continue;
                }

                String[] spl = p.split("\\*");
                if (p.endsWith("*")) {
                    String[] copy = new String[spl.length + 1];
                    for (int i2 = 0; i2 < spl.length; i2++) {
                        copy[i2] = spl[i2];
                    }
                    copy[spl.length] = "";
                    spl = copy;
                }
                String sh, lo;

                if (spl.length == 1) {
                    if (fixed) {
                        if (!spl[0].equals(fixedStr)) {
                            ok = false;
                            break;
                        }
                    }
                    fixed = true;
                    fixedStr = spl[0];
                }

                if (spl[0].length() > s.length()) {
                    sh = s;
                    lo = spl[0];
                } else {
                    sh = spl[0];
                    lo = s;
                }
                if (!sh.equals(lo.substring(0, sh.length()))) {
                    ok = false;
                    break;
                } else {
                    s = lo;
                }

                String last = spl[spl.length - 1];
                if (last.length() > e.length()) {
                    sh = e;
                    lo = last;
                } else {
                    sh = last;
                    lo = e;
                }
                if (!sh.equals(lo.substring(lo.length() - sh.length()))) {
                    ok = false;
                    break;
                } else {
                    e = lo;
                }

                for (int i2 = 1; i2 < spl.length - 1; i2++) {
                    mid.append(spl[i2]);
                }
            }

            for (int i1 = read; i1 < n; i1++) {
                sc.next();
            }

            if (!ok) {
                System.out.println(String.format("Case #%d: *", i + 1));
            } else if (fixed) {
                System.out.println(String.format("Case #%d: %s", i + 1, fixedStr));
            } else {
                String answer = s + mid.toString() + e;
                if (answer.length() == 0) {
                    answer = "GEDROX";
                }
                System.out.println(String.format("Case #%d: %s", i + 1, answer));
            }
        }
    }
}
