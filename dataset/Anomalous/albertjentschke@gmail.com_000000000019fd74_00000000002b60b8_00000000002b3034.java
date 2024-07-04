import java.util.*;

/**
 * For Google Code Jam 2020: Round 1A
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> output = new ArrayList<>();
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String start = "";
            String end = "";
            boolean invalidPattern = false;

            for (int j = 0; j < n; j++) {
                String pattern = scanner.nextLine();
                String[] parts = pattern.split("\\*");

                if (parts.length == 2 && !invalidPattern) {
                    String prefix = parts[0];
                    String suffix = parts[1];

                    if (prefix.isEmpty()) {
                        // Star at the beginning
                        if (!updateEnd(suffix, end)) {
                            invalidPattern = true;
                            output.add("*");
                        } else {
                            end = suffix.length() > end.length() ? suffix : end;
                        }
                    } else {
                        // Star in the middle
                        if (!updateEnd(suffix, end) || !updateStart(prefix, start)) {
                            invalidPattern = true;
                            output.add("*");
                        } else {
                            end = suffix.length() > end.length() ? suffix : end;
                            start = prefix.length() > start.length() ? prefix : start;
                        }
                    }
                } else if (!invalidPattern) {
                    // Star at the end
                    String prefix = parts[0];
                    if (!updateStart(prefix, start)) {
                        invalidPattern = true;
                        output.add("*");
                    } else {
                        start = prefix.length() > start.length() ? prefix : start;
                    }
                }
            }

            if (!invalidPattern) {
                output.add(start + end);
            }
        }

        for (int i = 0; i < output.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + output.get(i));
        }

        scanner.close();
    }

    private static boolean updateEnd(String newEnd, String currentEnd) {
        if (currentEnd.length() == newEnd.length()) {
            return currentEnd.equals(newEnd);
        } else if (currentEnd.length() < newEnd.length()) {
            return newEnd.endsWith(currentEnd);
        } else {
            return currentEnd.endsWith(newEnd);
        }
    }

    private static boolean updateStart(String newStart, String currentStart) {
        if (currentStart.length() == newStart.length()) {
            return currentStart.equals(newStart);
        } else if (currentStart.length() < newStart.length()) {
            return newStart.startsWith(currentStart);
        } else {
            return currentStart.startsWith(newStart);
        }
    }
}