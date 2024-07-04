import java.util.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            patterns.add(scanner.next());
        }

        patterns.sort(Comparator.comparingInt(String::length));

        boolean isValidPattern = true;
        String longestLeft = "", longestRight = "";

        for (String pattern : patterns) {
            int starIndex = pattern.indexOf('*');
            String leftPart = pattern.substring(0, starIndex);
            String rightPart = starIndex < pattern.length() - 1 ? pattern.substring(starIndex + 1) : "";

            if (!matches(longestLeft, leftPart) || !matches(longestRight, rightPart)) {
                isValidPattern = false;
                break;
            }

            if (leftPart.length() > longestLeft.length()) {
                longestLeft = leftPart;
            }
            if (rightPart.length() > longestRight.length()) {
                longestRight = rightPart;
            }
        }

        String result = isValidPattern ? longestLeft + longestRight : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private boolean matches(String longer, String shorter) {
        if (shorter.length() > longer.length()) {
            return longer.startsWith(shorter);
        } else {
            return shorter.startsWith(longer);
        }
    }
}