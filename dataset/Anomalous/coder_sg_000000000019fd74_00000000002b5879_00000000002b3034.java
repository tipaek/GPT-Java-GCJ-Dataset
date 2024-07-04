import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(reader.readLine());
            Set<String> substrings = new HashSet<>();
            String longestSubstring = "";
            boolean isValid = true;

            for (int j = 0; j < n; j++) {
                String input = reader.readLine();
                String sub = input.length() == 1 ? "" : input.substring(1);

                if (longestSubstring.isEmpty() || sub.length() > longestSubstring.length()) {
                    longestSubstring = sub;
                } else if (sub.length() == longestSubstring.length() && !longestSubstring.equals(sub)) {
                    isValid = false;
                }

                if (!isValid) break;
                substrings.add(sub);
            }

            if (isValid) {
                for (String sub : substrings) {
                    if (!longestSubstring.endsWith(sub)) {
                        isValid = false;
                        break;
                    }
                }
            }

            result.append("Case #").append(i + 1).append(": ").append(isValid ? longestSubstring : "*").append("\n");
        }

        System.out.print(result);
    }
}