import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	// write your code here
        short T, i, j, digit, cur, k;
        char ch;
        Scanner sc = new Scanner(System.in);
        String s;
        StringBuilder sb = new StringBuilder();
        T = sc.nextShort();
        for(i = 1; i <= T; i++) {
            s = sc.next();
            cur = 0;
            sb.setLength(0);
            for(j = 0; j < s.length(); j++) {
                ch = s.charAt(j);
                digit = (short) (ch - '0');
                if(cur > digit) {
                    for(k = 0; k < cur - digit; k++) sb.append(')');
                } else if (cur < digit) {
                    for(k = 0; k < digit - cur; k++) sb.append('(');
                }
                cur = digit;
                sb.append(ch);
            }
            for(k = 0; k < cur; k++) sb.append(')');

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}