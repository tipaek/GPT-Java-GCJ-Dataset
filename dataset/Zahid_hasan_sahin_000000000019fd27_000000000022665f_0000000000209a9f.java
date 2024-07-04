
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int p = 0;
        StringBuffer sb = new StringBuffer();
        while (t-- > 0) {
            ++p;

            String s = scan.next();
            s += "0";

            
            int n = 0;
            sb.append("Case #" + p + ": ");
            for (int i = 0; i < s.length(); i++) {
                int y = (s.charAt(i) - '0') - n;
                if (y > 0) {
                    while (y > 0) {
                        sb.append("(");
                        --y;
                    }
                    sb.append(s.charAt(i));
                } else if (y < 0) {
                    y = -y;
                    while (y > 0) {
                        sb.append(")");
                        --y;
                    }
                    sb.append(s.charAt(i));

                } else {
                    sb.append(s.charAt(i));
                }
                n = s.charAt(i) - '0';
            }
            sb = sb.delete(sb.length() - 1, sb.length());
            sb.append("\n");
            

        }
        System.out.println(sb);

    }
}
