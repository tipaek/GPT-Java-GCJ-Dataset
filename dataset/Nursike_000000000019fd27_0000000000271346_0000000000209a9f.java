import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tn = in.nextInt();
        in.nextLine();
        for (int t = 0; t < tn; t++) {
            solve(in, t + 1);
        }
    }

    private static void solve(Scanner in, int t) {
        String st = in.nextLine();
        StringBuilder sb = new StringBuilder();
        int opened = 0;
        for (int i = 0; i < st.length(); i++) {
            int cur = st.charAt(i) - '0';
            int d = Integer.compare(cur, opened);
            char c = cur < opened ? ')' : '(';
            while (opened != cur) {
                sb.append(c);
                opened += d;
            }
            sb.append((char)(cur + '0'));
        }
        for (int i = 0; i < opened; i++) {
            sb.append(')');
        }

        System.out.println("Case #" + t + ": " + sb.toString());
    }
}