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
            String longestString = null;
            Set<String> substrings = new HashSet<>();
            boolean isValid = true;

            for (int j = 0; j < n; j++) {
                String str = reader.readLine().replace("*", "");
                if (longestString == null || longestString.length() < str.length()) {
                    longestString = str;
                }
                substrings.add(str);
            }

            for (String str : substrings) {
                if (!longestString.endsWith(str)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.append("Case #").append(i + 1).append(": ").append(longestString).append("\n");
            } else {
                result.append("Case #").append(i + 1).append(": *\n");
            }
        }

        System.out.print(result);
    }
}