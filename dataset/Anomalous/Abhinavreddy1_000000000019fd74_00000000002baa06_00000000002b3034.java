import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = Integer.parseInt(reader.readLine());
            String[] patterns = new String[n];
            int maxLength = -1;
            int maxIndex = -1;

            for (int i = 0; i < n; i++) {
                patterns[i] = reader.readLine();
                if (patterns[i].length() > maxLength) {
                    maxLength = patterns[i].length();
                    maxIndex = i;
                }
            }

            StringBuilder targetBuilder = new StringBuilder();
            for (char c : patterns[maxIndex].toCharArray()) {
                if (c != '*') {
                    targetBuilder.append(c);
                }
            }
            String target = targetBuilder.toString();
            boolean isMatch = true;

            for (String pattern : patterns) {
                int startIndex = 0;
                int endIndex = 0;

                for (int j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) == '*') {
                        endIndex = j;
                        if (endIndex > startIndex) {
                            if (!target.contains(pattern.substring(startIndex, endIndex))) {
                                isMatch = false;
                                break;
                            }
                        }
                        startIndex = j + 1;
                    }
                    if (j == pattern.length() - 1 && pattern.charAt(j) != '*' && !target.contains(pattern.substring(startIndex, j + 1))) {
                        isMatch = false;
                    }
                }
                if (!isMatch) {
                    break;
                }
            }

            System.out.print("Case #" + (testCase + 1) + ": ");
            if (!isMatch) {
                System.out.println("*");
            } else {
                System.out.println(target);
            }
        }
    }
}