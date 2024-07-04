import java.util.*;

public class Main {
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
}

class SolutionPatternMatching {
    public void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            patterns.add(scanner.next());
        }

        patterns.sort(Comparator.comparingInt(String::length));

        patterns.forEach(System.out::println);

        boolean isPatternValid = true;
        String prevPattern = patterns.get(0);
        int asteriskIndex = prevPattern.indexOf("*");
        String prevLeft = prevPattern.substring(0, asteriskIndex);
        String prevRight = asteriskIndex < prevPattern.length() ? prevPattern.substring(asteriskIndex + 1) : "";

        System.out.println(String.format("Initial prevLeft = %s, prevRight = %s", prevLeft, prevRight));

        for (String currentPattern : patterns) {
            asteriskIndex = currentPattern.indexOf("*");
            String curLeft = currentPattern.substring(0, asteriskIndex);
            String curRight = asteriskIndex < currentPattern.length() ? currentPattern.substring(asteriskIndex + 1) : "";

            if (!isPrefixMatch(prevLeft, curLeft) || !isSuffixMatch(prevRight, curRight)) {
                isPatternValid = false;
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
        System.out.println(String.format(Main.OUTPUT_FORMAT, caseNum, result));
    }

    private boolean isPrefixMatch(String prevLeft, String curLeft) {
        int minLength = Math.min(prevLeft.length(), curLeft.length());
        for (int i = 0; i < minLength; i++) {
            if (prevLeft.charAt(i) != curLeft.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffixMatch(String prevRight, String curRight) {
        int prevLength = prevRight.length();
        int curLength = curRight.length();
        int minLength = Math.min(prevLength, curLength);
        for (int i = 0; i < minLength; i++) {
            if (prevRight.charAt(prevLength - 1 - i) != curRight.charAt(curLength - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}