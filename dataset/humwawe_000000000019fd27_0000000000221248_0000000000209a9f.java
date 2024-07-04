import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author hum
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        String result = "Case #%d: %s";
        for (int i = 1; i <= n; i++) {
            String s = sc.next();
            for (int j = 9; j >= 1; j--) {
                s = helper(s, j);
            }
            System.out.println(String.format(result, i, s));
        }
    }

    private static String helper(String s, int num) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (c - '0' >= num) {
                int j = i;
                for (; j < s.length(); j++) {
                    char cj = s.charAt(j);
                    if (cj == '(' || cj == ')') {
                        continue;
                    }
                    if (s.charAt(j) - '0' < num) {
                        break;
                    }
                }
                res.append('(');
                res.append(s, i, j);
                res.append(')');
                i = j;
            } else {
                i++;
                res.append(c);
            }
        }
        return res.toString();
    }
}
