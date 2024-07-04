import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= numberOfTestCases; t++) {
            int numberOfWords = Integer.parseInt(reader.readLine());
            String maxPrefix = "";
            String maxSuffix = "";
            boolean isValid = true;

            for (int w = 0; w < numberOfWords; w++) {
                String word = reader.readLine();
                int asteriskIndex = word.indexOf('*');
                String prefix = word.substring(0, asteriskIndex);
                String suffix = word.substring(asteriskIndex + 1);

                if (prefix.length() > maxPrefix.length()) {
                    if (!prefix.startsWith(maxPrefix)) {
                        isValid = false;
                    }
                    maxPrefix = prefix;
                } else {
                    if (!maxPrefix.startsWith(prefix)) {
                        isValid = false;
                    }
                }

                if (suffix.length() > maxSuffix.length()) {
                    if (!suffix.endsWith(maxSuffix)) {
                        isValid = false;
                    }
                    maxSuffix = suffix;
                } else {
                    if (!maxSuffix.endsWith(suffix)) {
                        isValid = false;
                    }
                }
            }

            if (isValid) {
                System.out.println("Case #" + t + ": " + maxPrefix + maxSuffix);
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
    }
}