import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            String s = in.next();
            StringBuilder s1 = new StringBuilder();
            int l = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int d = c - '0';
                while (l < d) {
                    s1.append('(');
                    ++l;
                }
                while (l > d) {
                    s1.append(')');
                    --l;
                }
                s1.append(c);
            }
            while (l > 0) {
                s1.append(')');
                --l;
            }
            System.out.println("Case #" + t + ": " + s1);
        }
    }
}
