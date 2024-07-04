import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// Nesting Depth
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            StringBuffer sb = new StringBuffer("Case #");
            sb.append(i).append(": ");

            String digits = in.next();
            int opened = 0;

            for (int charValue : digits.toCharArray()) {
                int digit = Character.getNumericValue(charValue);

                while (opened > digit) {
                    sb.append(')');
                    opened--;
                }

                while (digit > opened) {
                    sb.append('(');
                    opened++;
                }

                sb.append(digit);
            }

            while (opened > 0) {
                sb.append(')');
                opened--;
            }

            System.out.println(sb);
        }
    }
}
