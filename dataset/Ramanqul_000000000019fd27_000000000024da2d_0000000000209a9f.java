import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();

            StringBuilder sb = new StringBuilder();

            int prev = s.charAt(0) - '0';
            for (int k=0;k<prev;k++) {
                sb.append('(');
            }

            sb.append(prev);

            for (int j=1;j<s.length();j++) {
                int cur = s.charAt(j) - '0';

                int diff = prev-cur;

                for (int k=0;k<diff;k++) {
                    sb.append(')');
                }

                int diff2 = cur - prev;

                for (int k=0;k<diff2;k++) {
                    sb.append('(');
                }

                sb.append(cur);

                prev = cur;
            }

            for (int k=0;k<prev;k++) {
                sb.append(')');
            }

            System.out.printf("Case #%d: %s\n", i, sb);
        }
    }
}