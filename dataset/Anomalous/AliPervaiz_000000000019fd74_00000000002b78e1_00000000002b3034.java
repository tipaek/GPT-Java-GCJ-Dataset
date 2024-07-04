import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(input.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(input.readLine());
            String prefix = "";
            String suffix = "";
            StringBuilder middle = new StringBuilder();
            boolean isValid = true;

            for (int i = 0; i < n; i++) {
                String s = input.readLine();
                int prefixIndex = 0, suffixIndex = s.length() - 1;

                while (prefixIndex < s.length() && s.charAt(prefixIndex) != '*') {
                    if (prefixIndex == prefix.length()) {
                        prefix += s.charAt(prefixIndex);
                    } else if (prefix.charAt(prefixIndex) != s.charAt(prefixIndex)) {
                        isValid = false;
                        break;
                    }
                    prefixIndex++;
                }

                while (suffixIndex >= 0 && s.charAt(suffixIndex) != '*') {
                    int suffixPosition = s.length() - 1 - suffixIndex;
                    if (suffixPosition == suffix.length()) {
                        suffix += s.charAt(suffixIndex);
                    } else if (suffix.charAt(suffixPosition) != s.charAt(suffixIndex)) {
                        isValid = false;
                        break;
                    }
                    suffixIndex--;
                }

                for (int j = prefixIndex; j <= suffixIndex; j++) {
                    if (s.charAt(j) != '*') {
                        middle.append(s.charAt(j));
                    }
                }
            }

            StringBuilder reversedSuffix = new StringBuilder(suffix).reverse();
            out.print("Case #" + tc + ": ");

            if (isValid) {
                out.print(prefix);
                out.print(middle);
                out.println(reversedSuffix);
            } else {
                out.println("*");
            }
        }

        out.flush();
        out.close();
    }
}