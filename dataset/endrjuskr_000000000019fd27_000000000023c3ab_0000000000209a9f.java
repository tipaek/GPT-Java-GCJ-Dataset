import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            String s = in.next();
            StringBuilder builder = new StringBuilder();
            int prev = 0;
            for(int i = 0; i < s.length(); i++) {
                int k = s.charAt(i) - '0';
                if (prev > k) {
                    for (int j = k; j < prev; j++) {
                        builder.append(')');
                    }
                } else if (k > prev) {
                    for (int j = prev; j < k; j++) {
                        builder.append('(');
                    }
                }
                prev = k;
                builder.append(s.charAt(i));
            }
            for (int j = 0; j < prev; j++) {
                builder.append(')');
            }
            System.out.println(String.format("Case #%d: %s", t, builder.toString()));
        }
    }
}
