import java.util.Scanner;
import java.io.PrintWriter;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int test = 1; test <= testCases; test++) {
            char[] s = sc.nextLine().toCharArray();
            int n = s.length;
            int[] openParentheses = new int[n + 1];
            int[] closeParentheses = new int[n + 1];

            for (char d = '1'; d <= '9'; d++) {
                for (int i = 0; i < n; i++) {
                    if (s[i] >= d) {
                        int j = i;
                        while (j < n && s[j] >= d) {
                            j++;
                        }
                        openParentheses[i]++;
                        closeParentheses[j]++;
                        i = j - 1;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j < openParentheses[i]; j++) {
                    result.append('(');
                }
                for (int j = 0; j < closeParentheses[i]; j++) {
                    result.append(')');
                }
                if (i < n) {
                    result.append(s[i]);
                }
            }

            out.println("Case #" + test + ": " + result);
        }

        out.flush();
        out.close();
    }
}