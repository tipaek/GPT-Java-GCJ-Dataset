import java.util.*;

public class Solution {
    private static final String OUTPUT_TEMPLATE = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
                new Solution().processCase(caseNumber, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processCase(int caseNumber, Scanner scanner) {
        int n = scanner.nextInt();
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String pattern = scanner.next().replace("*", "");
            patterns.add(pattern);
        }

        patterns.sort(Comparator.comparingInt(String::length));

        boolean isPossible = true;
        String previousPattern = patterns.get(0);
        for (String currentPattern : patterns) {
            if (!currentPattern.contains(previousPattern)) {
                isPossible = false;
                break;
            }
            previousPattern = currentPattern;
        }

        String result = isPossible ? previousPattern : "*";
        System.out.println(String.format(OUTPUT_TEMPLATE, caseNumber, result));
    }
}