import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int N = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[N];

            for (int i = 0; i < N; i++) {
                patterns[i] = scanner.nextLine();
            }

            String commonSuffix = "";
            boolean hasSuffix = false;

            for (String pattern : patterns) {
                if (pattern.charAt(0) == '*') {
                    String suffix = pattern.substring(1);

                    if (!hasSuffix) {
                        commonSuffix = suffix;
                        hasSuffix = true;
                    } else {
                        if (commonSuffix.contains(suffix)) {
                            // No change needed
                        } else if (suffix.contains(commonSuffix)) {
                            commonSuffix = suffix;
                        } else {
                            commonSuffix = "";
                            break;
                        }
                    }
                }
            }

            if (commonSuffix.isEmpty()) {
                System.out.println("Case #" + testCase + ": *");
            } else {
                System.out.println("Case #" + testCase + ": " + commonSuffix);
            }
        }

        scanner.close();
    }
}