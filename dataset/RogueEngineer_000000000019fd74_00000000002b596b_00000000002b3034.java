import java.util.Scanner;

public class Solution {
    public static void p(String s) {System.out.print(s);}
    public static void pn(String s) {System.out.println(s); System.out.flush();}
    public static void ep(String s) {System.err.print(s);}
    public static void epn(String s) {System.err.println(s);}


    public static void caseN(Scanner sc, int t) {
        p("Case #" + t + ": ");
        int n = sc.nextInt();
        String longestMatch = "";
        boolean doesnotMatch = false;
        for (int i = 0; i < n; i++) {
           String p = sc.next();
           if (doesnotMatch) {
               continue;
           }
           String psuffix = p.substring(1);
           String shortStr;
           if (longestMatch.isEmpty()) {
               longestMatch = psuffix;
               continue;
           } else if (longestMatch.length() > psuffix.length()) {
               shortStr = psuffix;
           } else {
               shortStr = longestMatch;
               longestMatch = psuffix;
           }
           if (!longestMatch.contains(shortStr)) {
               doesnotMatch = true;
           }
        }
        if (doesnotMatch) {
            pn("*");
        } else {
            pn(longestMatch);
        }
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tNum = sc.nextInt();
        for (int t = 1; t <= tNum; t++) {
            caseN(sc, t);
        }
    }
}
