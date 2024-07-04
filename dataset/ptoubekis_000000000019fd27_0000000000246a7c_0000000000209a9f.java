import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; i++) {
            String s = in.next();
            System.out.println("Case #" + i + ": " + foo(s));
        }
    }

    private static String foo(String s) {
        StringBuilder sb = new StringBuilder();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            if (d < l) {
                for (int j = 0; j < l - d; j++) {
                    sb.append(')');
                }
            } else if (d > l) {
                for (int j = 0; j < d - l; j++) {
                    sb.append('(');
                }
            }
            sb.append(s.charAt(i));
            l = d;
        }
        for (int j = 0; j < l; j++) {
            sb.append(')');
        }
        return sb.toString();
    }

}
