import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            StringBuilder s = new StringBuilder();

            String u = sc.next();
            int prev = 0;
            for (int i1 = 0; i1 <= u.length(); i1++) {
                int next = i1 == u.length() ? 0 : u.charAt(i1) - '0';
                for (int i2 = 0; i2 < next - prev; i2++) {
                    s.append('(');
                }
                for (int i2 = 0; i2 < prev - next; i2++) {
                    s.append(')');
                }
                if (i1 < u.length()) {
                    s.append(u.charAt(i1));
                }
                prev = next;
            }

            System.out.println(String.format("Case #%d: %s", i + 1, s.toString()));
        }
    }
}
