import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Solution obj = new Solution();
            int testCases = Integer.parseInt(br.readLine());

            for (int t = 0; t < testCases; t++) {
                int N = Integer.parseInt(br.readLine());
                List<String> patterns = new ArrayList<>();

                for (int n = 0; n < N; n++) {
                    patterns.add(br.readLine());
                }

                String result = obj.patternMatching(patterns);
                if (result.length() > 10000) {
                    System.out.println("Case #" + (t + 1) + ": *");
                } else {
                    System.out.println("Case #" + (t + 1) + ": " + result);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public String patternMatching(List<String> patterns) {
        String startsWith = "";
        String endsWith = "";
        boolean canGenerate = true;

        for (String pattern : patterns) {
            String prefix = pattern.substring(0, pattern.indexOf('*'));
            String suffix = pattern.substring(pattern.indexOf('*') + 1);

            if (prefix.length() >= startsWith.length()) {
                if (startsWith.isEmpty() || prefix.startsWith(startsWith)) {
                    startsWith = prefix;
                } else {
                    canGenerate = false;
                    break;
                }
            } else if (!startsWith.startsWith(prefix)) {
                canGenerate = false;
                break;
            }

            if (suffix.length() >= endsWith.length()) {
                if (endsWith.isEmpty() || suffix.endsWith(endsWith)) {
                    endsWith = suffix;
                } else {
                    canGenerate = false;
                    break;
                }
            } else if (!endsWith.endsWith(suffix)) {
                canGenerate = false;
                break;
            }
        }

        if (canGenerate) {
            if (startsWith.endsWith(endsWith) && !startsWith.equals(endsWith)) {
                return startsWith;
            } else if (endsWith.startsWith(startsWith) && !endsWith.equals(startsWith)) {
                return endsWith;
            } else {
                return startsWith + endsWith;
            }
        } else {
            return "*";
        }
    }
}