import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(br.readLine());
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                new Solution().processCase(caseNum, br);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            patterns.add(br.readLine());
        }

        patterns.sort(Comparator.comparingInt(String::length));

        String prefix = "", suffix = "";
        boolean isValid = true;

        for (String pattern : patterns) {
            int asteriskIndex = pattern.indexOf('*');
            String currentPrefix = pattern.substring(0, asteriskIndex);
            String currentSuffix = pattern.substring(asteriskIndex + 1);

            if (!prefix.startsWith(currentPrefix) && !currentPrefix.startsWith(prefix)) {
                isValid = false;
                break;
            }
            if (!suffix.endsWith(currentSuffix) && !currentSuffix.endsWith(suffix)) {
                isValid = false;
                break;
            }

            if (currentPrefix.length() > prefix.length()) {
                prefix = currentPrefix;
            }
            if (currentSuffix.length() > suffix.length()) {
                suffix = currentSuffix;
            }
        }

        String result = isValid ? prefix + suffix : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }
}