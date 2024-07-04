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

            String longestSuffix = "";
            boolean suffixFound = false;
            boolean multipleSuffixes = false;

            for (String pattern : patterns) {
                if (pattern.charAt(0) == '*') {
                    String currentSuffix = pattern.substring(1);

                    if (longestSuffix.isEmpty()) {
                        longestSuffix = currentSuffix;
                        suffixFound = true;
                    } else {
                        if (longestSuffix.contains(currentSuffix)) {
                            longestSuffix = currentSuffix;
                            multipleSuffixes = true;
                        } else if (currentSuffix.contains(longestSuffix)) {
                            longestSuffix = currentSuffix;
                            multipleSuffixes = true;
                        }
                    }
                }
            }

            if (suffixFound && !multipleSuffixes && N > 1) {
                longestSuffix = "";
            }

            if (longestSuffix.isEmpty()) {
                System.out.println("*");
            } else {
                System.out.println(longestSuffix);
            }
        }
    }
}