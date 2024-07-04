import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static BufferedReader in;
    static List<String[]> allPatterns = new ArrayList<>();

    public static void main(String[] args) {
        readSquares();

        int i = 1;

        for (String[] patterns : allPatterns) {
            findMatching(patterns, i);
            i++;
        }
    }


    private static void findMatching(String[] patterns, int testcaseId) {
        String matchingPattern;
        String prefix = "";
        String postfix = "";


        for (String pattern : patterns) {
            String[] fractals = pattern.split("\\*");
            String newPrefix = fractals[0];
            String newPostfix = "";
            if (fractals.length > 1) {
                newPostfix = fractals[fractals.length - 1];
            }

            if (!newPrefix.equals("")) {
                if (prefix.equals("")) {
                    prefix = newPrefix;
                } else {
                    if (prefix.length() >= newPrefix.length()) {
                        if (!newPrefix.equals(prefix.substring(0, newPrefix.length()))) {
                            doesNotMatch(testcaseId);
                            return;
                        }
                    } else {
                        if (!prefix.equals(newPrefix.substring(0, prefix.length()))) {
                            doesNotMatch(testcaseId);
                            return;
                        } else {
                            prefix = newPrefix;
                        }
                    }
                }
            }

            if (!newPostfix.equals("")) {
                if (postfix.equals("")) {
                    postfix = newPostfix;
                } else {
                    if (postfix.length() >= newPostfix.length()) {
                        if (!newPostfix.equals(postfix.substring(postfix.length() - newPostfix.length()))) {
                            doesNotMatch(testcaseId);
                            return;
                        }
                    } else {
                        if (!postfix.equals(newPostfix.substring(newPostfix.length() - postfix.length()))) {
                            doesNotMatch(testcaseId);
                            return;
                        } else {
                            postfix = newPostfix;
                        }
                    }
                }
            }
        }

        matchingPattern = prefix + postfix;

        System.out.println("Case #" + testcaseId + ": " + matchingPattern);
    }

    private static void doesNotMatch(int testcaseId) {
        System.out.println("Case #" + testcaseId + ": " + "*");
    }

    public static void readSquares() {
        in = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = in.readLine();

            int numberOfTestCases = Integer.parseInt(line);

            for (int i = 0; i < numberOfTestCases; i++) {
                line = in.readLine();

                int numberOfPatterns = Integer.parseInt(line);

                String[] patterns = new String[numberOfPatterns];

                for (int j = 0; j < numberOfPatterns; j++) {
                    line = in.readLine();
                    patterns[j] = line;
                }

                allPatterns.add(patterns);
            }
        } catch (IOException e) {
            System.out.println("something went wrong during reading input");
        }
    }
}
