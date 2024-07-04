import java.util.*;

/**
 * For Google Code Jam 2020: Round 1A
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> output = new ArrayList<>();
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after the integer input
            String start = "";
            String end = "";
            StringBuilder middle = new StringBuilder();
            boolean isInvalid = false;

            for (int j = 0; j < n; j++) {
                String pattern = scanner.nextLine();
                if (!isInvalid) {
                    boolean startsWithChar = pattern.charAt(0) != '*';
                    boolean endsWithChar = pattern.charAt(pattern.length() - 1) != '*';
                    String[] parts = pattern.split("\\*");

                    for (int k = 0; k < parts.length; k++) {
                        if (k == 0 && startsWithChar) {
                            start = mergeStart(start, parts[k]);
                            if (start.equals("*")) {
                                isInvalid = true;
                                output.add("*");
                                break;
                            }
                        } else if (k == parts.length - 1 && endsWithChar) {
                            end = mergeEnd(end, parts[k]);
                            if (end.equals("*")) {
                                isInvalid = true;
                                output.add("*");
                                break;
                            }
                        } else if (k > 0 && k < parts.length - 1) {
                            middle.append(parts[k]);
                        }
                    }
                }
            }
            if (!isInvalid) {
                output.add(start + middle.toString() + end);
            }
        }

        for (int i = 0; i < output.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + output.get(i));
        }
        scanner.close();
    }

    private static String mergeStart(String start, String newStart) {
        if (start.length() == newStart.length()) {
            return start.equals(newStart) ? start : "*";
        } else if (start.length() < newStart.length()) {
            return newStart.startsWith(start) ? newStart : "*";
        } else {
            return start.startsWith(newStart) ? start : "*";
        }
    }

    private static String mergeEnd(String end, String newEnd) {
        if (end.length() == newEnd.length()) {
            return end.equals(newEnd) ? end : "*";
        } else if (end.length() < newEnd.length()) {
            return newEnd.endsWith(end) ? newEnd : "*";
        } else {
            return end.endsWith(newEnd) ? end : "*";
        }
    }
}