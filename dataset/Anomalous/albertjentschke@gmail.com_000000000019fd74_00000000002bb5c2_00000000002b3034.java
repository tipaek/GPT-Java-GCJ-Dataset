import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> results = new ArrayList<>();
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            int patternsCount = scanner.nextInt();
            scanner.nextLine();
            String start = "", end = "", middle = "";
            boolean invalid = false;

            for (int j = 0; j < patternsCount; j++) {
                String pattern = scanner.nextLine();
                if (invalid) continue;

                if (!pattern.isEmpty() && !(pattern.length() == 1 && pattern.charAt(0) == '*')) {
                    String[] parts = pattern.split("\\*");
                    boolean isStart = pattern.charAt(0) != '*';
                    boolean isEnd = pattern.charAt(pattern.length() - 1) != '*';

                    for (int k = 0; k < parts.length; k++) {
                        if (k == 0 && isStart) {
                            start = updateStart(start, parts[0]);
                            if (start.equals("*")) {
                                invalid = true;
                                results.add("*");
                            }
                        } else if (k == parts.length - 1 && isEnd) {
                            end = updateEnd(end, parts[parts.length - 1]);
                            if (end.equals("*")) {
                                invalid = true;
                                results.add("*");
                            }
                        } else {
                            if (!middle.contains(parts[k])) {
                                middle += parts[k];
                            }
                        }
                    }
                }
            }

            if (!invalid) {
                if (start.length() + end.length() + middle.length() < 10000) {
                    results.add(start + middle + end);
                } else {
                    results.add("*");
                }
            }
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }

        scanner.close();
    }

    private static String updateStart(String start, String newStart) {
        if (start.length() == newStart.length()) {
            return start.equals(newStart) ? start : "*";
        } else if (start.length() < newStart.length()) {
            return newStart.startsWith(start) ? newStart : "*";
        } else {
            return start.startsWith(newStart) ? start : "*";
        }
    }

    private static String updateEnd(String end, String newEnd) {
        if (end.length() == newEnd.length()) {
            return end.equals(newEnd) ? end : "*";
        } else if (end.length() < newEnd.length()) {
            return newEnd.endsWith(end) ? newEnd : "*";
        } else {
            return end.endsWith(newEnd) ? end : "*";
        }
    }
}