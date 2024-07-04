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
                System.out.println("Case #" + (t + 1) + ": " + result);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String patternMatching(List<String> patterns) {
        StringBuilder finalPattern = new StringBuilder();
        String startsWith = "";
        String endsWith = "";
        boolean canGenerate = true;

        for (String pattern : patterns) {
            int starIndex = pattern.indexOf('*');
            String prefix = pattern.substring(0, starIndex);
            String suffix = pattern.substring(starIndex + 1);

            if (startsWith.length() <= prefix.length()) {
                if (startsWith.isEmpty() || prefix.startsWith(startsWith)) {
                    startsWith = prefix;
                } else {
                    canGenerate = false;
                }
            }

            if (endsWith.length() <= suffix.length()) {
                if (endsWith.isEmpty() || suffix.endsWith(endsWith)) {
                    endsWith = suffix;
                } else {
                    canGenerate = false;
                }
            }
        }

        return canGenerate ? startsWith + endsWith : "*";
    }
}