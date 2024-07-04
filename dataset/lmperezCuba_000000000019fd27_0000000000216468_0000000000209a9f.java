import java.util.Scanner;

/**
 *
 * @author lmperez
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String S = sc.next();
            int lenght = S.length(), left = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < lenght; j++) {
                int d = S.charAt(j) - '0';
                if (d > left) {
                    while (d-- > left) {
                        sb.append("(");
                    }
                    left = S.charAt(j) - '0';
                } else if (d < left) {
                    while (d < left) {
                        left--;
                        sb.append(")");
                    }
                }
                sb.append(S.charAt(j));
            }
            while (left-- > 0) {
                sb.append(")");
            }
            System.out.printf("Case #%d: %s\n", (i + 1), sb.toString());
        }
    }

}
