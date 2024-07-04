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

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int numberOfStrings = Integer.parseInt(reader.readLine());
            Set<String> suffixes = new HashSet<>();
            String longestSuffix = null;
            boolean isValid = true;

            for (int strIndex = 0; strIndex < numberOfStrings; strIndex++) {
                String inputString = reader.readLine();
                String suffix = inputString.length() == 1 ? "" : inputString.substring(1);

                if (longestSuffix == null) {
                    longestSuffix = suffix;
                } else {
                    if (longestSuffix.length() < suffix.length()) {
                        longestSuffix = suffix;
                    } else if (longestSuffix.length() == suffix.length() && !longestSuffix.equals(suffix)) {
                        isValid = false;
                    }
                }

                if (!isValid) {
                    break;
                }

                suffixes.add(suffix);
            }

            if (isValid) {
                for (String suffix : suffixes) {
                    if (!longestSuffix.endsWith(suffix)) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                result.append("Case #").append(caseIndex + 1).append(": ").append(longestSuffix).append("\n");
            } else {
                result.append("Case #").append(caseIndex + 1).append(": *\n");
            }
        }

        System.out.print(result);
    }
}