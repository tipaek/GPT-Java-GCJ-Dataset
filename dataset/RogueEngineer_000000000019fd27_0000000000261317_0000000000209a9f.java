import java.util.Scanner;

public class Solution {
    public static void p(String s) {System.out.print(s);}
    public static void pn(String s) {System.out.println(s);}
    public static void ep(String s) {System.err.print(s);}
    public static void epn(String s) {System.err.println(s);}


    public static void caseN(Scanner s, int t) {
        p("Case #" + t + ": ");
        String sline = s.next();
        int depth = 0;
        int lastDigit = 0;
        int parenDepth = 0;
        for (int i = 0; i < sline.length(); i++) {
            char sc = sline.charAt(i);
            int sv = Character.getNumericValue(sc);
            depth = sv - lastDigit;
            for (int d = 0; d > depth; d--) {
                p(")");
                parenDepth--;
            }
            for (int d = 0; d < depth; d++) {
                p("(");
                parenDepth++;
            }
            p(String.valueOf(sv));
            lastDigit = sv;
        }
        for (int d = 0; d < parenDepth; d++) {
            p(")");
        }
        pn("");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tNum = s.nextInt();
        for (int t = 1; t <= tNum; t++) {
            caseN(s, t);
        }
    }
}
