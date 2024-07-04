import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Solution solution = new Solution();
            int testCases = Integer.parseInt(br.readLine());

            for (int t = 0; t < testCases; t++) {
                int N = Integer.parseInt(br.readLine());
                List<String> patterns = new ArrayList<>();

                for (int n = 0; n < N; n++) {
                    patterns.add(br.readLine());
                }

                String result = solution.patternMatching2(patterns);
                System.out.println("Case #" + (t + 1) + ": " + result);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public String patternMatching2(List<String> patterns) {
        String startsWith = "";
        String endsWith = "";
        boolean canGenerate = true;

        for (String pattern : patterns) {
            String prefix = pattern.substring(0, pattern.indexOf('*'));
            String suffix = pattern.substring(pattern.indexOf('*') + 1);

            if (startsWith.length() <= prefix.length()) {
                if (startsWith.isEmpty() || prefix.startsWith(startsWith)) {
                    startsWith = prefix;
                } else {
                    canGenerate = false;
                }
            } else {
                if (!startsWith.startsWith(prefix)) {
                    canGenerate = false;
                }
            }

            if (endsWith.length() <= suffix.length()) {
                if (endsWith.isEmpty() || suffix.endsWith(endsWith)) {
                    endsWith = suffix;
                } else {
                    canGenerate = false;
                }
            } else {
                if (!endsWith.endsWith(suffix)) {
                    canGenerate = false;
                }
            }
        }

        if (canGenerate) {
            if (startsWith.endsWith(endsWith)) {
                return startsWith;
            } else if (endsWith.startsWith(startsWith)) {
                return endsWith;
            } else {
                return startsWith + endsWith;
            }
        } else {
            return "*";
        }
    }
}