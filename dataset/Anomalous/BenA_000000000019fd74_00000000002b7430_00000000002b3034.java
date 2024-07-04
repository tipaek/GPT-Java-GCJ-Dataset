import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int numberOfWords = Integer.parseInt(scanner.nextLine());
            String[] words = new String[numberOfWords];

            for (int i = 0; i < numberOfWords; i++) {
                words[i] = scanner.nextLine();
            }

            String result = mergeWords(words);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static String mergeWords(String[] words) {
        String prefix = "";
        String suffix = "";

        for (String word : words) {
            int asteriskIndex = word.indexOf('*');

            // Check and update prefix
            int minPrefixLength = Math.min(prefix.length(), asteriskIndex);
            if (!word.substring(0, minPrefixLength).equals(prefix.substring(0, minPrefixLength))) {
                return "*";
            }
            if (asteriskIndex > prefix.length()) {
                prefix = word.substring(0, asteriskIndex);
            }

            // Check and update suffix
            int suffixLength = word.length() - asteriskIndex - 1;
            int minSuffixLength = Math.min(suffix.length(), suffixLength);
            if (!word.substring(word.length() - minSuffixLength).equals(suffix.substring(suffix.length() - minSuffixLength))) {
                return "*";
            }
            if (suffixLength > suffix.length()) {
                suffix = word.substring(asteriskIndex + 1);
            }
        }

        return prefix + suffix;
    }
}