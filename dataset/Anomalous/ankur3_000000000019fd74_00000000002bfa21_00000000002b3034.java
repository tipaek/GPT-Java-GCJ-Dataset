import java.util.Scanner;

class Round1A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        int totalCases = testCaseCount;

        while (testCaseCount-- > 0) {
            int n = scanner.nextInt();
            String[] arr = new String[n];
            String[] startParts = new String[n];
            String[] endParts = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.next();
                startParts[i] = extractStart(arr[i]);
                endParts[i] = extractEnd(arr[i]);
            }

            String startString = constructStartString(startParts);
            if (startString.equals("*")) {
                System.out.println("Case #" + (totalCases - testCaseCount) + ": *");
            } else {
                String endString = constructEndString(endParts);
                if (endString.equals("*")) {
                    System.out.println("Case #" + (totalCases - testCaseCount) + ": *");
                } else {
                    StringBuilder mainString = new StringBuilder();
                    for (String s : arr) {
                        int startIdx = s.indexOf('*');
                        int endIdx = s.lastIndexOf('*');
                        if (startIdx != -1 && endIdx != -1 && startIdx != endIdx) {
                            mainString.append(s, startIdx + 1, endIdx);
                        }
                    }
                    System.out.println("Case #" + (totalCases - testCaseCount) + ": " + startString + mainString + endString);
                }
            }
        }

        scanner.close();
    }

    private static String constructEndString(String[] endParts) {
        String longestEnd = "";
        for (String end : endParts) {
            if (end.length() > longestEnd.length()) {
                longestEnd = end;
            }
        }

        for (String end : endParts) {
            if (!longestEnd.startsWith(end)) {
                return "*";
            }
        }

        return new StringBuilder(longestEnd).reverse().toString();
    }

    private static String constructStartString(String[] startParts) {
        String longestStart = "";
        for (String start : startParts) {
            if (start.length() > longestStart.length()) {
                longestStart = start;
            }
        }

        for (String start : startParts) {
            if (!longestStart.startsWith(start)) {
                return "*";
            }
        }

        return longestStart;
    }

    private static String extractStart(String s) {
        int asteriskIndex = s.indexOf('*');
        return asteriskIndex == -1 ? s : s.substring(0, asteriskIndex);
    }

    private static String extractEnd(String s) {
        int asteriskIndex = s.lastIndexOf('*');
        return asteriskIndex == -1 ? "" : s.substring(asteriskIndex + 1);
    }
}