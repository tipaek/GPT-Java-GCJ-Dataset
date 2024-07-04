import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int p = 0; p < t; p++) {
            int n = Integer.parseInt(br.readLine());
            String[] patterns = new String[n];
            int maxLength = -1;
            int maxIndex = -1;

            for (int i = 0; i < n; i++) {
                patterns[i] = br.readLine();
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
            boolean isValid = true;

            for (String pattern : patterns) {
                int start = 0;
                int end = 0;

                for (int j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) == '*') {
                        end = j;
                        if (end > start) {
                            if (!target.contains(pattern.substring(start, end))) {
                                isValid = false;
                                break;
                            }
                        }
                        start = j + 1;
                    }
                    if (j == pattern.length() - 1 && pattern.charAt(j) != '*' && !target.contains(pattern.substring(start, j + 1))) {
                        isValid = false;
                    }
                }

                if (!isValid) {
                    break;
                }
            }

            System.out.print("Case #" + (p + 1) + ": ");
            if (!isValid) {
                System.out.println("*");
            } else {
                System.out.println(target);
            }
        }
    }
}