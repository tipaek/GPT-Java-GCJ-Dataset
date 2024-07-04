import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        for (int i = 0; i < tc; i++) {
            String input = scanner.next();
            String re = get(input);

            System.out.println("Case #"+(i+1) +": " + re);
        }
    }
    private static String get(String input) {
        int now = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            int should = c - '0';
            if (should == now) {
                sb.append(should);
                continue;
            }
            if (should > now) {
                for (int i = 0; i < should - now; i++) sb.append('(');
                sb.append(should);
                now = should;
            } else {
                for (int i = 0; i < now - should; i++) sb.append(')');
                sb.append(should);
                now = should;
            }
        }
        for (int i = 0; i < now; i++) sb.append(')');
        return sb.toString();
    }

}