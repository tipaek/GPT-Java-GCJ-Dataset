import java.util.Scanner;

public class Solution {

    public static String solve(String s) {
        StringBuilder sb = new StringBuilder();
        int d = 0;
        for (int i=0; i<s.length(); i++) {
            int digit = s.charAt(i) - '0';
            if (digit > d) {
                for (int j=0; j<digit-d; j++) {
                    sb.append('(');
                }
            } else if (digit < d) {
                for (int j=0; j<d-digit; j++) {
                    sb.append(')');
                }
            }
            sb.append(digit);
            d = digit;
        }
        if (d > 0) {
            for (int j=0; j<d; j++) {
                sb.append(')');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            for (int i=0; i<t; i++) {
                String s = sc.next();
                String sol = solve(s);
                System.out.printf("Case #%s: %s%n", i+1, sol);
            }
        }
    }

}
