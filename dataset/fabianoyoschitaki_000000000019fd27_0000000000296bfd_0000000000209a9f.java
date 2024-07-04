import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {
        int tests = scan.nextInt();
        for (int i = 0; i < tests; i++) {
            String s = scan.next();
            System.out.println("Case #" + (i+1) + ": " + nestDepth(s));
        }
    }

    private static String nestDepth(String s) {
        StringBuffer result = new StringBuffer();
        int openings = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer current = s.charAt(i) - 48;
            if (current > openings) {
                for (; openings < current; openings++, result.append("(")) {}
            } else if (current < openings) {
                for (;openings > current; openings--, result.append(")")) {}
            }
            result.append(current);
        }
        for (int i = 0; i < openings; i++) {
            result.append(")");
        }
        return result.toString();
    }
}
