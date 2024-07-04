import java.util.Scanner;

// Nesting Depth
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
            String S = in.next();
            StringBuilder sb = new StringBuilder();
            int depth = 0;
            for (char c : S.toCharArray()) {
                int digit = c - '0';
                for (int i=depth; i<digit; i++) {
                    sb.append('(');
                }
                for (int i=depth; i>digit; i--) {
                    sb.append(')');
                }
                sb.append(c);
                depth = digit;
            }
            for (int i=depth; i>0; i--) {
                sb.append(')');
            }
            System.out.printf("Case #%d: %s\n", t, sb.toString());
        }
    }

}
