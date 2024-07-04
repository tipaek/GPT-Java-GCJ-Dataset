import java.util.Scanner;

/**
 *
 * @author arabtech
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int z = 0; z < t; z++) {
            String s = sc.next();
            int n = s.length();
            StringBuilder ans = new StringBuilder();
            int prev = s.charAt(0) - '0';
            for (int i = 0; i < prev; i++) {
                ans.append('(');
            }
            ans.append(prev);
            for (int i = 1; i < n; i++) {
                int current = s.charAt(i) - '0';
                if (s.charAt(i) - '0' > prev) {
                    for (int j = 0; j < current - prev; j++) {
                        ans.append('(');
                    }
                } else if (current < prev) {
                    for (int j = 0; j < prev - current; j++) {
                        ans.append(')');
                    }
                }
                ans.append(current);
                prev = current;
            }
            for (int j = 0; j < prev; j++) {
                ans.append(')');
            }
            System.out.println("Case #" + (z + 1) + ": " + ans.toString());
        }

    }

}
