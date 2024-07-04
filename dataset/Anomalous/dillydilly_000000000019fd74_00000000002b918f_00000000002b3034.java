import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String result = processCase(scanner);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String processCase(Scanner scanner) {
        List<String> patterns = new ArrayList<>();
        int numberOfPatterns = scanner.nextInt();
        String error = "";

        for (int i = 0; i < numberOfPatterns; i++) {
            String pattern = scanner.next();
            int asteriskIndex = pattern.indexOf('*');
            patterns.add("");
            int segmentIndex = 0;

            while (asteriskIndex != -1) {
                String segment = pattern.substring(0, asteriskIndex);
                ensureCapacity(patterns, segmentIndex + 2);

                if (asteriskIndex == 0) {
                    segmentIndex++;
                    pattern = pattern.substring(1);
                    asteriskIndex = pattern.indexOf('*');
                } else {
                    String existingSegment = patterns.get(segmentIndex);
                    if (existingSegment.isEmpty()) {
                        patterns.set(segmentIndex, segment);
                    } else if (!existingSegment.contains(segment) && !segment.contains(existingSegment)) {
                        error = "*";
                    } else if (segment.length() > existingSegment.length()) {
                        patterns.set(segmentIndex, segment);
                    }
                    pattern = pattern.substring(asteriskIndex + 1);
                    asteriskIndex = pattern.indexOf('*');
                    segmentIndex += 2;
                }
            }

            String lastSegment = patterns.get(segmentIndex);
            if (!pattern.contains(lastSegment) && !lastSegment.contains(pattern)) {
                error = "*";
            } else if (pattern.length() > lastSegment.length()) {
                patterns.set(segmentIndex, pattern);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String segment : patterns) {
            result.append(segment);
        }

        return error.isEmpty() ? result.toString() : error;
    }

    private static void ensureCapacity(List<String> list, int size) {
        while (list.size() <= size) {
            list.add("");
        }
    }
}