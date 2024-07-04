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
            int stringCount = Integer.parseInt(reader.readLine());
            Set<String> uniqueStrings = new HashSet<>();
            String longestString = null;
            boolean isValid = true;

            for (int strIndex = 0; strIndex < stringCount; strIndex++) {
                String inputString = reader.readLine();
                String processedString = inputString.length() > 1 ? inputString.substring(1) : "";

                if (longestString == null || processedString.length() > longestString.length()) {
                    longestString = processedString;
                } else if (processedString.length() == longestString.length() && !processedString.equals(longestString)) {
                    isValid = false;
                    break;
                }

                uniqueStrings.add(processedString);
            }

            if (isValid) {
                for (String str : uniqueStrings) {
                    if (!longestString.endsWith(str)) {
                        isValid = false;
                        break;
                    }
                }
            }

            result.append("Case #").append(caseIndex + 1).append(": ");
            result.append(isValid ? longestString : "*").append("\n");
        }

        System.out.print(result);
    }
}