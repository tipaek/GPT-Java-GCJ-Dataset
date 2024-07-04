import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            StringBuilder start = new StringBuilder();
            StringBuilder end = new StringBuilder();
            StringBuilder middle = new StringBuilder();

            boolean isInvalid = false;

            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                int len = s.length();
                int startIndex = 0;

                while (s.charAt(startIndex) != '*') {
                    if (startIndex < start.length()) {
                        if (start.charAt(startIndex) != s.charAt(startIndex)) {
                            isInvalid = true;
                            break;
                        }
                    } else {
                        start.append(s.charAt(startIndex));
                    }
                    startIndex++;
                }

                if (isInvalid) break;

                int endIndex = 0;
                while (s.charAt(len - 1 - endIndex) != '*') {
                    if (endIndex < end.length()) {
                        if (end.charAt(endIndex) != s.charAt(len - 1 - endIndex)) {
                            isInvalid = true;
                            break;
                        }
                    } else {
                        end.append(s.charAt(len - 1 - endIndex));
                    }
                    endIndex++;
                }

                if (isInvalid) break;

                int middleIndex = startIndex;
                while (middleIndex < len - 1 - endIndex) {
                    if (s.charAt(middleIndex) != '*') {
                        middle.append(s.charAt(middleIndex));
                    }
                    middleIndex++;
                }
            }

            String result;
            if (isInvalid) {
                result = "*";
            } else {
                result = start.toString() + middle.toString() + end.reverse().toString();
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}