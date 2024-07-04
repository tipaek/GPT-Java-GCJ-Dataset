import java.util.*;

public class SolutionPatternMatching {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new SolutionPatternMatching().processCase(caseNum, scanner);
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

        boolean isPatternMatched = true;
        String prevPattern = patterns.get(0);
        String prevLeft = prevPattern.split("\\*", 2)[0];
        String prevRight = prevPattern.contains("*") ? prevPattern.split("\\*", 2)[1] : "";

        for (String pattern : patterns) {
            String curLeft = pattern.split("\\*", 2)[0];
            String curRight = pattern.contains("*") ? pattern.split("\\*", 2)[1] : "";

            if (!isPrefixMatching(prevLeft, curLeft) || !isSuffixMatching(prevRight, curRight)) {
                isPatternMatched = false;
                break;
            }

            if (curLeft.length() > prevLeft.length()) {
                prevLeft = curLeft;
            }

            if (curRight.length() > prevRight.length()) {
                prevRight = curRight;
            }
        }

        String result = isPatternMatched ? prevLeft + prevRight : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }

    private boolean isPrefixMatching(String prev, String current) {
        int minLength = Math.min(prev.length(), current.length());
        for (int i = 0; i < minLength; i++) {
            if (prev.charAt(i) != current.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixMatching(String prev, String current) {
        int prevLength = prev.length();
        int currentLength = current.length();
        int minLength = Math.min(prevLength, currentLength);

        for (int i = 1; i <= minLength; i++) {
            if (prev.charAt(prevLength - i) != current.charAt(currentLength - i)) {
                return false;
            }
        }
        return true;
    }
}