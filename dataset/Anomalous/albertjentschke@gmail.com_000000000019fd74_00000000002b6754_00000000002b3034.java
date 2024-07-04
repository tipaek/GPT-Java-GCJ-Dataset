import java.util.*;

/**
 * For Google Code Jam 2020: Round 1A
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> output = new ArrayList<>();
        int t = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            String start = "";
            String end = "";
            boolean stop = false;

            for (int j = 0; j < n; j++) {
                String pattern = scanner.nextLine();
                String[] strArray = pattern.split("\\*");

                if (strArray.length == 2 && !stop) {
                    String prefix = strArray[0];
                    String suffix = strArray[1];

                    if (prefix.isEmpty()) {
                        // Star at beginning
                        stop = !updateEnd(suffix, end, output);
                        if (!stop) end = suffix.length() > end.length() ? suffix : end;
                    } else {
                        // Star in the middle
                        stop = !updateEnd(suffix, end, output) || !updateStart(prefix, start, output);
                        if (!stop) {
                            end = suffix.length() > end.length() ? suffix : end;
                            start = prefix.length() > start.length() ? prefix : start;
                        }
                    }
                } else if (!stop) {
                    // Star ending
                    String prefix = strArray[0];
                    stop = !updateStart(prefix, start, output);
                    if (!stop) start = prefix.length() > start.length() ? prefix : start;
                }
            }

            if (!stop) {
                output.add(start + end);
            }
        }

        for (int i = 0; i < output.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + output.get(i));
        }

        scanner.close();
    }

    private static boolean updateEnd(String newSuffix, String currentEnd, List<String> output) {
        if (currentEnd.length() == newSuffix.length()) {
            if (!currentEnd.equals(newSuffix)) {
                output.add("*");
                return false;
            }
        } else if (currentEnd.length() < newSuffix.length()) {
            if (!newSuffix.endsWith(currentEnd)) {
                output.add("*");
                return false;
            }
        } else {
            if (!currentEnd.endsWith(newSuffix)) {
                output.add("*");
                return false;
            }
        }
        return true;
    }

    private static boolean updateStart(String newPrefix, String currentStart, List<String> output) {
        if (currentStart.length() == newPrefix.length()) {
            if (!currentStart.equals(newPrefix)) {
                output.add("*");
                return false;
            }
        } else if (currentStart.length() < newPrefix.length()) {
            if (!newPrefix.startsWith(currentStart)) {
                output.add("*");
                return false;
            }
        } else {
            if (!currentStart.startsWith(newPrefix)) {
                output.add("*");
                return false;
            }
        }
        return true;
    }
}