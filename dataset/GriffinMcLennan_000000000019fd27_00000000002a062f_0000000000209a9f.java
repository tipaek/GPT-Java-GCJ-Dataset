import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int numCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numCases; i++) {
            String s = scanner.nextLine();
            solve(i + 1, s);
        }
    }

    private static void solve(int c, String s) {
        StringBuilder sb = new StringBuilder();

        int prev = Character.getNumericValue(s.charAt(0));

        for (int i = 0; i < prev; i++) {
            sb.append('(');
        }
        sb.append(prev);

        for (int i = 1; i < s.length(); i++) {
            int cur = Character.getNumericValue(s.charAt(i));

            if (cur == prev) {
                sb.append(cur);
            }
            else if (cur > prev) {
                for (int j = 0; j < cur - prev; j++) {
                    sb.append('(');
                }

                sb.append(cur);
            }
            else {
                for (int j = 0; j < prev - cur; j++) {
                    sb.append(')');
                }

                sb.append(cur);
            }

            prev = cur;
        }

        for (int i = 0; i < prev; i++) {
            sb.append(')');
        }

        System.out.printf("Case #%d: %s\n", c, sb.toString());
    }
}