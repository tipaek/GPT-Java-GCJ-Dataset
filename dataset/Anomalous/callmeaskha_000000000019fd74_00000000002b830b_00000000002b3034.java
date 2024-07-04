import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            int numberOfWords = Integer.parseInt(reader.readLine());
            String longestPrefix = "";
            String longestSuffix = "";
            boolean isValid = true;

            for (int j = 0; j < numberOfWords; j++) {
                String input = reader.readLine();
                int asteriskIndex = input.indexOf('*');
                String prefix = input.substring(0, asteriskIndex);
                String suffix = input.substring(asteriskIndex + 1);

                if (prefix.length() > longestPrefix.length()) {
                    if (!prefix.startsWith(longestPrefix)) {
                        isValid = false;
                    }
                    longestPrefix = prefix;
                } else {
                    if (!longestPrefix.startsWith(prefix)) {
                        isValid = false;
                    }
                }

                if (suffix.length() > longestSuffix.length()) {
                    if (!suffix.endsWith(longestSuffix)) {
                        isValid = false;
                    }
                    longestSuffix = suffix;
                } else {
                    if (!longestSuffix.endsWith(suffix)) {
                        isValid = false;
                    }
                }
            }

            if (isValid) {
                System.out.println(longestPrefix + longestSuffix);
            } else {
                System.out.println("*");
            }
        }
    }
}