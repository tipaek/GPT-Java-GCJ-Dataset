import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numPatterns = scanner.nextInt();
            scanner.nextLine();
            Pattern pattern = new Pattern();
            boolean isValid = true;
            
            for (int i = 0; i < numPatterns; i++) {
                if (!pattern.merge(scanner.nextLine().trim())) {
                    isValid = false;
                    break;
                }
            }
            
            System.out.println("Case #" + caseNum + ": " + (isValid ? pattern.getValue() : "*"));
        }
        
        scanner.close();
    }

    private static class Pattern {
        private LinkedList<String> parts;

        public Pattern() {
            parts = new LinkedList<>();
        }

        public boolean merge(String input) {
            String[] splitParts = input.split("\\*");
            
            if (parts.isEmpty()) {
                if (input.charAt(0) == '*') {
                    parts.add("");
                }
                for (String part : splitParts) {
                    parts.add(part);
                }
                if (input.charAt(input.length() - 1) == '*') {
                    parts.add("");
                }
                return true;
            }

            if (parts.getFirst().startsWith(splitParts[0]) || input.charAt(0) == '*') {
                if (parts.getLast().endsWith(splitParts[splitParts.length - 1]) || input.charAt(input.length() - 1) == '*') {
                    // Do nothing
                } else if (splitParts[splitParts.length - 1].endsWith(parts.getLast())) {
                    parts.pollLast();
                    parts.addLast(splitParts[splitParts.length - 1]);
                } else {
                    return false;
                }
                for (int i = 1; i < splitParts.length - 1; i++) {
                    parts.add(1, splitParts[i]);
                }
            } else if (splitParts[0].startsWith(parts.getFirst())) {
                parts.set(0, splitParts[0]);
                if (parts.getLast().endsWith(splitParts[splitParts.length - 1]) || input.charAt(input.length() - 1) == '*') {
                    // Do nothing
                } else if (splitParts[splitParts.length - 1].endsWith(parts.getLast())) {
                    parts.pollLast();
                    parts.addLast(splitParts[splitParts.length - 1]);
                } else {
                    return false;
                }
                for (int i = 1; i < splitParts.length - 1; i++) {
                    parts.add(1, splitParts[i]);
                }
            }
            return true;
        }

        public String getValue() {
            StringBuilder result = new StringBuilder();
            for (String part : parts) {
                result.append(part);
            }
            return result.toString();
        }
    }
}