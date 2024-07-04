import java.util.*;

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

        patterns.forEach(System.out::println);

        boolean isPatternValid = true;
        String prevPattern = patterns.get(0);
        int starIndex = prevPattern.indexOf("*");
        String prevLeft = prevPattern.substring(0, starIndex);
        String prevRight = starIndex < prevPattern.length() ? prevPattern.substring(starIndex + 1) : "";

        System.out.println(String.format("Initial prevLeft = %s, prevRight = %s", prevLeft, prevRight));

        for (String pattern : patterns) {
            starIndex = pattern.indexOf("*");
            String curLeft = pattern.substring(0, starIndex);
            String curRight = starIndex < pattern.length() ? pattern.substring(starIndex + 1) : "";

            isPatternValid = compareSegments(prevLeft, curLeft) && compareSegments(new StringBuilder(prevRight).reverse().toString(), new StringBuilder(curRight).reverse().toString());

            System.out.println(String.format("Comparing: i1 = %d, i2 = %d, isPatternValid = %s", prevLeft.length(), curLeft.length(), isPatternValid));

            if (!isPatternValid) {
                break;
            }

            if (curLeft.length() > prevLeft.length()) {
                prevLeft = curLeft;
            }
            if (curRight.length() > prevRight.length()) {
                prevRight = curRight;
            }

            System.out.println(String.format("Updated prevLeft = %s, prevRight = %s", prevLeft, prevRight));
        }

        String result = isPatternValid ? prevLeft + prevRight : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private boolean compareSegments(String segment1, String segment2) {
        int len1 = segment1.length(), len2 = segment2.length();
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (segment1.charAt(i) != segment2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}