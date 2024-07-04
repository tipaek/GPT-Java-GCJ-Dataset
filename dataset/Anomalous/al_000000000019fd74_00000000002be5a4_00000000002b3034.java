import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            int patternCount = scanner.nextInt();
            List<String> patternList = new ArrayList<>();
            for (int patternIndex = 0; patternIndex < patternCount; patternIndex++) {
                patternList.add(scanner.next());
            }
            String result = findPattern(patternList);
            System.out.println("Case #" + (testIndex + 1) + ": " + result);
        }
    }

    private static String findPattern(List<String> patterns) {
        int position = 0;
        while (patterns.size() > 1) {
            char currentChar = '-';
            for (int i = patterns.size() - 1; i >= 0; i--) {
                String pattern = patterns.get(i);
                int charIndex = pattern.length() - position - 1;
                if (charIndex < 1) {
                    patterns.remove(i);
                    continue;
                }
                char charAtPosition = pattern.charAt(charIndex);
                if (currentChar == '-') {
                    currentChar = charAtPosition;
                } else if (currentChar != charAtPosition) {
                    return "*";
                }
            }
            position++;
        }
        String longestPattern = patterns.get(0);
        return longestPattern.substring(1);
    }
}