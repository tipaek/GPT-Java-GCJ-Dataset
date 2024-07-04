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
            boolean canFormPattern = true;

            for (int j = 0; j < numberOfWords; j++) {
                String currentWord = reader.readLine();
                int asteriskPosition = currentWord.indexOf('*');
                String prefix = currentWord.substring(0, asteriskPosition);
                String suffix = currentWord.substring(asteriskPosition + 1);

                if (prefix.length() > longestPrefix.length()) {
                    if (!prefix.startsWith(longestPrefix)) {
                        canFormPattern = false;
                    }
                    longestPrefix = prefix;
                } else {
                    if (!longestPrefix.startsWith(prefix)) {
                        canFormPattern = false;
                    }
                }

                if (suffix.length() > longestSuffix.length()) {
                    if (!suffix.endsWith(longestSuffix)) {
                        canFormPattern = false;
                    }
                    longestSuffix = suffix;
                } else {
                    if (!longestSuffix.endsWith(suffix)) {
                        canFormPattern = false;
                    }
                }
            }

            if (canFormPattern) {
                System.out.println(longestPrefix + longestSuffix);
            } else {
                System.out.println("*");
            }
        }
    }
}