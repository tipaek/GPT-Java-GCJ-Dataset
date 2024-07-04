import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int patternCount = scanner.nextInt();
            scanner.nextLine();
            Pattern pattern = new Pattern();
            boolean isValid = true;

            for (int i = 0; i < patternCount; i++) {
                if (!pattern.merge(scanner.nextLine().trim())) {
                    isValid = false;
                    break;
                }
            }

            System.out.println("Case #" + testCase + ": " + (isValid ? pattern.getValue() : "*"));
        }

        scanner.close();
    }

    private static class Pattern {
        private LinkedList<String> segments;

        public Pattern() {
            segments = new LinkedList<>();
        }

        public boolean merge(String input) {
            System.out.println(input);
            String[] parts = input.split("\\*");

            if (segments.isEmpty()) {
                if (input.charAt(0) == '*') {
                    segments.add("");
                }

                for (String part : parts) {
                    segments.add(part);
                }

                if (input.charAt(input.length() - 1) == '*') {
                    segments.add("");
                }

                return true;
            }

            if (segments.getFirst().startsWith(parts[0]) || input.charAt(0) == '*') {
                if (!isLastSegmentValid(parts, input)) {
                    return false;
                }

                for (int i = 1; i < parts.length - 1; i++) {
                    segments.add(1, parts[i]);
                }
            } else if (parts[0].startsWith(segments.getFirst())) {
                segments.set(0, parts[0]);

                if (!isLastSegmentValid(parts, input)) {
                    return false;
                }

                for (int i = 1; i < parts.length - 1; i++) {
                    segments.add(1, parts[i]);
                }
            }

            return true;
        }

        private boolean isLastSegmentValid(String[] parts, String input) {
            if (segments.getLast().endsWith(parts[parts.length - 1]) || input.charAt(input.length() - 1) == '*') {
                return true;
            } else if (parts[parts.length - 1].endsWith(segments.getLast())) {
                segments.pollLast();
                segments.addLast(parts[parts.length - 1]);
                return true;
            } else {
                System.out.println(getValue());
                System.out.println(input);
                System.out.println(1);
                return false;
            }
        }

        public String getValue() {
            StringBuilder result = new StringBuilder();
            for (String segment : segments) {
                result.append(segment);
            }
            return result.toString();
        }
    }
}