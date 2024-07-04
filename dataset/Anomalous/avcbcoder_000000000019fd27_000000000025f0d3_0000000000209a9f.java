import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            System.out.print("Case #" + i + ": ");
            solve(br);
        }
    }

    public static void solve(BufferedReader br) throws IOException {
        String s = br.readLine();
        String result = processString(0, s.length() - 1, s, 0);
        System.out.println(result);
    }

    private static String processString(int l, int r, String s, int level) {
        boolean[] digitsPresent = new boolean[10];
        int minDigit = 10;

        for (int i = l; i <= r; i++) {
            int digit = s.charAt(i) - '0';
            digitsPresent[digit] = true;
            minDigit = Math.min(minDigit, digit);
        }

        StringBuilder prefix = new StringBuilder();
        StringBuilder suffix = new StringBuilder();
        for (int i = 0; i < minDigit - level; i++) {
            prefix.append("(");
            suffix.append(")");
        }

        StringBuilder result = new StringBuilder();
        result.append(prefix);

        for (int i = l; i <= r;) {
            int j = i;
            int end = i;
            if (s.charAt(i) - '0' == minDigit) {
                StringBuilder mid = new StringBuilder();
                while (j <= r && s.charAt(j) - '0' == minDigit) {
                    end = j;
                    mid.append(s.charAt(j));
                    j++;
                }
                result.append(mid);
            } else {
                while (j <= r && s.charAt(j) - '0' != minDigit) {
                    end = j;
                    j++;
                }
                result.append(processString(i, end, s, minDigit));
            }
            i = j;
        }

        result.append(suffix);

        return result.toString();
    }
}