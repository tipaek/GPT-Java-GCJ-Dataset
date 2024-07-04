import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution_PatternMatching {

    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution_PatternMatching().getAnswer(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAnswer(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> patterns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            patterns.add(scanner.next());
        }

        patterns.sort(Comparator.comparingInt(String::length));

        for (String pattern : patterns) {
            System.out.println(pattern);
        }

        boolean isPatternMatching = true;
        String prevPattern = patterns.get(0);
        int asteriskIndex = prevPattern.indexOf('*');
        String prevLeft = prevPattern.substring(0, asteriskIndex);
        String prevRight = asteriskIndex < prevPattern.length() - 1 ? prevPattern.substring(asteriskIndex + 1) : "";

        System.out.printf("Initial prevLeft = %s, prevRight = %s%n", prevLeft, prevRight);

        for (String pattern : patterns) {
            asteriskIndex = pattern.indexOf('*');
            String curLeft = pattern.substring(0, asteriskIndex);
            String curRight = asteriskIndex < pattern.length() - 1 ? pattern.substring(asteriskIndex + 1) : "";

            if (!isPrefixMatching(prevLeft, curLeft) || !isSuffixMatching(prevRight, curRight)) {
                isPatternMatching = false;
                break;
            }

            if (curLeft.length() > prevLeft.length()) {
                prevLeft = curLeft;
            }
            if (curRight.length() > prevRight.length()) {
                prevRight = curRight;
            }

            System.out.printf("Updated prevLeft = %s, prevRight = %s%n", prevLeft, prevRight);
        }

        String result = isPatternMatching ? prevLeft + prevRight : "*";
        System.out.printf(OUTPUT_FORMAT, caseNum, result);
    }

    private boolean isPrefixMatching(String prevLeft, String curLeft) {
        int minLength = Math.min(prevLeft.length(), curLeft.length());
        for (int i = 0; i < minLength; i++) {
            if (prevLeft.charAt(i) != curLeft.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixMatching(String prevRight, String curRight) {
        int minLength = Math.min(prevRight.length(), curRight.length());
        for (int i = 0; i < minLength; i++) {
            if (prevRight.charAt(prevRight.length() - 1 - i) != curRight.charAt(curRight.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}