import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author thangbq
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nTestCase = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= nTestCase; ++i) {
            sb.setLength(0);
            String S = in.next();
            byte[] chars = S.getBytes();
            sb.append("Case #").append(i).append(" ");
            int currentOpen = 0;
            for (byte aChar : chars) {
                byte val = (byte) (aChar - 48);
                if (val > currentOpen) {
                    for (; currentOpen < val; currentOpen++) {
                        sb.append("(");
                    }
                }

                if (val < currentOpen) {
                    for (; currentOpen > val; currentOpen--) {
                        sb.append(")");
                    }
                }
                sb.append(val);
            }
            if (currentOpen > 0) {
                for (; currentOpen > 0; currentOpen--) {
                    sb.append(")");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
