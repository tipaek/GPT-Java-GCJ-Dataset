import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int tt = 1; tt <= t; tt++) {
            int n = Integer.parseInt(sc.nextLine());
            String[] all = new String[n];
            for (int i = 0; i < n; i++) {
                all[i] = sc.nextLine();
            }

            StringBuilder res1 = new StringBuilder();
            boolean ok = true;
            outer:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < all[i].length(); j++) {
                    if (all[i].charAt(j) == '*') {
                        break;
                    }
                    ok = match(res1, j, all[i].charAt(j));
                    if (!ok) {
                        break outer;
                    }
                }
            }


            StringBuilder res2 = new StringBuilder();
            if (ok) {
                outer:
                for (int i = 0; i < n; i++) {
                    for (int j = all[i].length() - 1; j >= 0; j--) {
                        if (all[i].charAt(j) == '*') {
                            break;
                        }
                        ok = match(res2, all[i].length() - 1 - j, all[i].charAt(j));
                        if (!ok) {
                            break outer;
                        }
                    }
                }
                res2.reverse();
            }

            String s = null;
            if (ok) {
                if (res1.length() + res2.length() <= 10000) {
                    s = res1.toString() + res2.toString();
                } else {
                    s = combine(res1, res2);
                }
            }

            if (!ok || s == null) {
                System.out.println("Case #" + tt + ": *");
            } else {
                System.out.println("Case #" + tt + ": " + s);
            }


        }
    }

    private static String combine(StringBuilder res1, StringBuilder res2) {
        for (int i = 0; i < res1.length(); i++) {
            boolean good = true;
            for (int j = 0; j < res1.length() - i; j++) {
                if (res1.charAt(i + j) != res2.charAt(j)) {
                    good = false;
                    break;
                }
            }
            if (good) {
                return res1.toString() + res2.substring(res2.length() - i);
            }
        }
        return null;
    }

    private static boolean match(StringBuilder sb, int i, char ch) {
        if (sb.length() <= i) {
            sb.append(ch);
            return true;
        }
        return sb.charAt(i) == ch;
    }
}
