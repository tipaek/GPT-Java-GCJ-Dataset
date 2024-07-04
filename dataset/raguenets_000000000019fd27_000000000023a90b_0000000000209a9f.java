import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t=1; t <= T; t++) {
            String S = scanner.next();
            StringBuilder sb = new StringBuilder();

            char[] s = S.toCharArray();
            int prev = s[0] - '0';
            for (int i=0; i < prev; i++) sb.append('(');
            sb.append(s[0]);
            int openParen = prev;
            int index = 1;
            while (index < s.length) {
                int d = s[index] - '0';
                if (d > prev) {
                    for (int i=0; i < d - prev; i++) sb.append('(');
                    openParen += d - prev;
                } else if (d < prev) {
                    for (int i=0; i < prev - d; i++) sb.append(')');
                    openParen += d - prev;
                }
                sb.append(s[index]);
                prev = d;
                index++;
            }
            if (openParen >0) {
                for (int i=0; i < openParen; i++) sb.append(')');
            }
            System.out.println("Case #"+t+": "+sb.toString());
        }
        
    }
}