import java.util.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
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

        boolean isPatternValid = true;
        String previousPattern = patterns.get(0);

        for (String currentPattern : patterns) {
            if (!isPatternValid) break;

            char[] prevChars = previousPattern.toCharArray();
            char[] curChars = currentPattern.toCharArray();
            int prevLen = prevChars.length, curLen = curChars.length;
            int prevIndex = 0, curIndex = 0;

            while (prevIndex < prevLen && curIndex < curLen) {
                if (prevChars[prevIndex] == '*' && curChars[curIndex] == '*') {
                    prevIndex++;
                    curIndex++;
                    break;
                }
                if (prevChars[prevIndex] == '*') {
                    curIndex++;
                } else if (prevChars[prevIndex] == curChars[curIndex]) {
                    prevIndex++;
                    curIndex++;
                } else {
                    isPatternValid = false;
                    break;
                }
            }

            if (!isPatternValid) break;

            int prevEndIndex = prevLen - 1, curEndIndex = curLen - 1;
            while (prevEndIndex >= prevIndex && curEndIndex >= curIndex) {
                if (prevChars[prevEndIndex] == curChars[curEndIndex]) {
                    prevEndIndex--;
                    curEndIndex--;
                } else {
                    isPatternValid = false;
                    break;
                }
            }

            if (!isPatternValid) break;

            previousPattern = currentPattern;
        }

        String result = isPatternValid ? previousPattern.replace("*", "") : "*";
        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result));
    }
}