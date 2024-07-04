import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] patterns = new String[n];
            String[] prefixes = new String[n];
            String[] suffixes = new String[n];
            String[] middles = new String[n];

            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.nextLine();
                prefixes[i] = patterns[i].substring(0, patterns[i].indexOf("*"));
                suffixes[i] = new StringBuilder(patterns[i].substring(patterns[i].lastIndexOf("*") + 1)).reverse().toString();
                if (patterns[i].indexOf("*") != patterns[i].lastIndexOf("*")) {
                    middles[i] = patterns[i].substring(patterns[i].indexOf("*") + 1, patterns[i].lastIndexOf("*")).replace("*", "");
                } else {
                    middles[i] = "";
                }
            }

            boolean isFail = false;
            StringBuilder beginningBuilder = new StringBuilder();
            for (String prefix : prefixes) {
                if (isFail) {
                    break;
                }
                char[] chars = prefix.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (i >= beginningBuilder.length()) {
                        beginningBuilder.append(chars[i]);
                    } else if (beginningBuilder.charAt(i) != chars[i]) {
                        isFail = true;
                        break;
                    }
                }
            }

            String beginning = beginningBuilder.toString();

            StringBuilder endingBuilder = new StringBuilder();
            for (String suffix : suffixes) {
                if (isFail) {
                    break;
                }
                char[] chars = suffix.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (i >= endingBuilder.length()) {
                        endingBuilder.append(chars[i]);
                    } else if (endingBuilder.charAt(i) != chars[i]) {
                        isFail = true;
                        break;
                    }
                }
            }

            String ending = endingBuilder.reverse().toString();

            StringBuilder resultBuilder = new StringBuilder(beginning);
            for (String middle : middles) {
                resultBuilder.append(middle);
            }
            resultBuilder.append(ending);

            String result = resultBuilder.toString();
            if (isFail || result.length() > 10000) {
                System.out.println("Case #" + (t + 1) + ": *");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + result);
            }
        }
        scanner.close();
    }
}