
/**
 * @author egaeus
 * @date 04/04/2020
 **/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class Solution {
    public static void main(String args[]) throws Throwable {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t++ < T; ) {
            sb.append("Case #").append(t).append(": ");
            char[] str = in.readLine().toCharArray();
            for (int i = 0; i < str.length; i++) {
                int a = str[i] - '0', b = i > 0 ? str[i - 1] - '0' : 0;
                for (int j = b; j < a; j++) sb.append("(");
                for (int j = a; j < b; j++) sb.append(")");
                sb.append(str[i]);
            }
            int b = str[str.length - 1] - '0';
            for (int i = 0; i < b; i++)
                sb.append(")");
            sb.append("\n");
        }
        System.out.print(new String(sb));
    }
}
