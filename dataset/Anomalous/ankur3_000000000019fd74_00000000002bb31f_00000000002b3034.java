import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int totalCases = testCases;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            String[] arr = new String[n];
            String[] start = new String[n];
            String[] end = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.next();
                start[i] = extractStart(arr[i]);
                end[i] = extractEnd(arr[i]);
            }

            String startString = computeStartString(start);
            if (startString.equals("*")) {
                System.out.println("Case #" + (totalCases - testCases) + ": *");
            } else {
                String endString = computeEndString(end);
                if (endString.equals("*")) {
                    System.out.println("Case #" + (totalCases - testCases) + ": *");
                } else {
                    StringBuilder mainString = new StringBuilder();
                    for (String s : arr) {
                        int startIdx = s.indexOf('*');
                        int endIdx = s.lastIndexOf('*');
                        if (startIdx != -1 && endIdx != -1 && startIdx != endIdx) {
                            mainString.append(s, startIdx + 1, endIdx);
                        }
                    }
                    System.out.println("Case #" + (totalCases - testCases) + ": " + startString + mainString + new StringBuilder(endString).reverse());
                }
            }
        }
        scanner.close();
    }

    private static String computeEndString(String[] end) {
        String longest = "";
        for (String s : end) {
            if (s.length() > longest.length()) {
                longest = s;
            }
        }

        for (String s : end) {
            if (!longest.contains(s)) {
                return "*";
            }
        }
        return longest;
    }

    private static String computeStartString(String[] start) {
        String longest = "";
        for (String s : start) {
            if (s.length() > longest.length()) {
                longest = s;
            }
        }

        for (String s : start) {
            if (!longest.contains(s)) {
                return "*";
            }
        }
        return longest;
    }

    private static String extractStart(String s) {
        int idx = s.indexOf('*');
        return (idx == -1) ? s : s.substring(0, idx);
    }

    private static String extractEnd(String s) {
        int idx = s.lastIndexOf('*');
        return (idx == -1) ? "" : s.substring(idx + 1);
    }
}