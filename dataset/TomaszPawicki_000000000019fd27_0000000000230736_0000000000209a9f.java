import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 1; t <= T; t++) {
            String str = s.next();
            StringBuilder sb = new StringBuilder();
            int prev = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                int nr = (ch - '0');
                int dif = nr - prev;
                if (dif >= 0) {
                    for (int j = 0; j < dif; j++) {
                        sb.append("(");
                    }
                } else {
                    for (int j = 0; j < -dif; j++) {
                        sb.append(")");
                    }
                }
                sb.append(ch);
                prev = nr;
            }
            for (int j = 0; j < prev; j++) {
                sb.append(")");
            }
            System.out.println("Case #" + t + ": " + sb.toString());

        }
    }
}
