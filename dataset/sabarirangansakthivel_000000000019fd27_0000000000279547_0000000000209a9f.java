import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t;
        t = scanner.nextInt();
        int tno;
        for (tno = 1; tno <= t; tno++) {
            String s = scanner.next();
            StringBuilder sb = new StringBuilder();
            int i;
            int nesting = 0;
            for (i = 0; i < s.length(); i++) {
                int a = Character.getNumericValue(s.charAt(i));
                for (; nesting < a; nesting++) {
                    sb.append("(");
                }
                for (; nesting > a; nesting--) {
                    sb.append(")");
                }
                sb.append(s.charAt(i));
            }
            for (; nesting > 0; nesting--) {
                sb.append(")");
            }
            System.out.println(String.format("Case #%d: %s",tno, sb.toString()));
        }
    }
}