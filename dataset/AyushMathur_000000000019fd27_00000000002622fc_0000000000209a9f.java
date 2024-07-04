import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= T; t++) {
            output.append("Case #").append(t).append(": ");

            String s = reader.readLine().trim();

            output.append(getBalancedString(s)).append("\n");
        }

        System.out.print(output);
    }

    private static String getBalancedString(String s) {
        int l = s.length();
        int[] bracketCounts = new int[l + 2];

        for (int i = 1; i <= l; i++) {
            bracketCounts[i] = Integer.parseInt(s.substring(i - 1, i));
        }

        StringBuilder balancedString = new StringBuilder();

        for (int i = 0; i <= l; i++) {
            int diff = bracketCounts[i + 1] - bracketCounts[i];

            if (diff > 0) {
                while (diff-- > 0) {
                    balancedString.append("(");
                }
            } else if (diff < 0) {
                diff = -diff;
                while (diff-- > 0) {
                    balancedString.append(")");
                }
            }

            if (i < l) {
                balancedString.append(bracketCounts[i + 1]);
            }
        }

        return balancedString.toString();
    }
}
