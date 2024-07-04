import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cases = 1; cases <= t; cases++) {
            int n = sc.nextInt();
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = sc.next();
            }
            int[] startIdxs = new int[n];
            int[] endIdxs = new int[n];
            for (int i = 0; i < n; i++) {
                endIdxs[i] = patterns[i].length() - 1;
            }
            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            boolean isValid = true;

            while (true) {
                boolean allStars = true;
                char currentChar = 0;

                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(startIdxs[i]) != '*') {
                        allStars = false;
                        if (currentChar == 0) {
                            currentChar = patterns[i].charAt(startIdxs[i]);
                        } else if (currentChar != patterns[i].charAt(startIdxs[i])) {
                            isValid = false;
                            break;
                        }
                    }
                }

                if (!isValid || allStars) break;

                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(startIdxs[i]) == currentChar) {
                        startIdxs[i]++;
                    }
                }
                prefix.append(currentChar);
            }

            while (true) {
                boolean allStars = true;
                char currentChar = 0;

                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(endIdxs[i]) != '*') {
                        allStars = false;
                        if (currentChar == 0) {
                            currentChar = patterns[i].charAt(endIdxs[i]);
                        } else if (currentChar != patterns[i].charAt(endIdxs[i])) {
                            isValid = false;
                            break;
                        }
                    }
                }

                if (!isValid || allStars) break;

                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(endIdxs[i]) == currentChar) {
                        endIdxs[i]--;
                    }
                }
                suffix.append(currentChar);
            }

            for (int i = 0; i < n; i++) {
                for (int j = startIdxs[i]; j <= endIdxs[i]; j++) {
                    if (patterns[i].charAt(j) != '*') {
                        prefix.append(patterns[i].charAt(j));
                    }
                }
            }

            if (isValid) {
                System.out.println("Case #" + cases + ": " + prefix + suffix.reverse());
            } else {
                System.out.println("Case #" + cases + ": *");
            }
        }
        sc.close();
    }
}