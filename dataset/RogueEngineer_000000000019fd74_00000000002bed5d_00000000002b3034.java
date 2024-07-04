import java.util.Scanner;

public class Solution {
    public static void p(String s) {System.out.print(s);}
    public static void pn(String s) {System.out.println(s); System.out.flush();}
    public static void ep(String s) {System.err.print(s);}
    public static void epn(String s) {System.err.println(s);}

    public static void caseN(Scanner sc, int t) {
        p("Case #" + t + ": ");
        int n = sc.nextInt();
        String longestPrefix = "";
        String longestSuffix = "";
        boolean doesnotMatch = false;
        for (int i = 0; i < n; i++) {
           String p = sc.next();
           if (doesnotMatch) {
               continue;
           }
           int asteriskPos = p.indexOf('*');
           String pPrefix = p.substring(0, asteriskPos);
           String pSuffix = p.substring(asteriskPos + 1);
           String longestStr = "";
           String shorterPrefix;
           String shorterSuffix;
           if (longestPrefix.isEmpty() && longestSuffix.isEmpty()) {
               longestPrefix = pPrefix;
               longestSuffix = pSuffix;
               continue;
           }
            if (longestPrefix.length() > pPrefix.length()) {
                shorterPrefix = pPrefix;
            } else {
                shorterPrefix = longestPrefix;
                longestPrefix = pPrefix;
            }

           if (longestSuffix.length() > pSuffix.length()) {
               shorterSuffix = pSuffix;
           } else {
               shorterSuffix = longestSuffix;
               longestSuffix = pSuffix;
           }

           if (!longestPrefix.startsWith(shorterPrefix)
            || !longestSuffix.endsWith(shorterSuffix)) {
               doesnotMatch = true;
           }
        }
        if (doesnotMatch) {
            pn("*");
        } else {
            pn(longestPrefix + longestSuffix);
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
