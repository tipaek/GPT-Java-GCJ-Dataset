
import java.util.*;
import java.io.*;

public class Solution {
    public static PrintWriter out;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt(), cc = 0;
        while (t-->0) {
            String ans = null;
            out.printf("Case #%d: ", ++cc);
            String end = "";
            String start = "";
            int n = sc.nextInt();
            String[] ws = new String[n];
            boolean good = true;
            for (int i = 0; i < n; i++){
                ws[i] = sc.next();
                String pref = getPref(ws[i]);
                String suff = getSuff(ws[i]);
                if (start.length() < pref.length()) {
                    if (!pref.startsWith(start))
                        good = false;
                    start = pref;
                }
                else {
                    if (!start.startsWith(pref))
                        good = false;
                }
                if (end.length() < suff.length()) {
                    if (!suff.endsWith(end))
                        good = false;
                        end = suff;
                }
                else {
                    if (!end.endsWith(suff))
                        good = false;
                }
                if (pref.length() == ws[i].length())
                    ans = ws[i];
            }
            if (ans != null && good) {
                good = (start.length() == ans.length()) && (end.length() == ans.length());
                for (int i = 0; i < n && good; i++)
                    if(!check(ans, ws[i]))
                        good = false;
            }
            //System.err.println(start +" " +end);
            if (!good)
                out.println("*");
            else {
                if (ans != null){
                    out.println(ans);
                    continue;
                }
                out.print(start);
                for (int i = 0; i < n; i++)
                    out.print(ws[i].replaceAll("\\*", ""));
                out.println(end);
            }
        }
        out.close();
    }
    public static boolean check(String ans, String sub) {
        if (sub.equals(ans)) return true;
        int n = sub.length();
        int n2 = ans.length();
        int pos = 0;
        for (int i = 0; i < n; i++){
            int j = i;
            if (sub.charAt(i) == '*') continue;
            while (j < n && sub.charAt(j) != '*')
                j++;
            int nn = j - i;
            while (pos < n2 && !ans.substring(pos).startsWith(sub.substring(i,j)))
                pos++;
            if (pos == n2)
                return false;
            pos += nn;
            i = j - 1;
        }
        return true;
    }
    public static String getPref(String a) {
        if (a.length() == 0 || a.charAt(0) == '*')
            return "";
        return a.charAt(0) + getPref(a.substring(1));
    }
    public static String getSuff(String a) {
        int n = a.length() - 1;
        if (a.length() == 0 || a.charAt(n) == '*')
            return "";
        return getSuff(a.substring(0,n)) + a.charAt(n);
    }
}