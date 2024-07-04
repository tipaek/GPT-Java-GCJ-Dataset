import java.util.*;

public class Solution {
    private final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            if (!solveCase(t)) {
                System.out.println(String.format("Case #%d: *", t));
            }
        }
    }

    private boolean solveCase(int t) {
        int n = in.nextInt();
        String[] patterns = new String[n];
        for (int i = 0; i < n; i++) {
            patterns[i] = in.next();
        }
        StringBuilder result = new StringBuilder();

        if (!processPatterns(patterns, n, result)) {
            return false;
        }

        System.out.println(String.format("Case #%d: %s", t, result.toString()));
        return true;
    }

    private boolean processPatterns(String[] patterns, int n, StringBuilder result) {
        int[] pos = new int[n];
        while (true) {
            boolean completed = true;
            Character currentChar = null;

            for (int i = 0; i < n; i++) {
                String pattern = patterns[i];
                if (pos[i] < pattern.length()) {
                    char c = pattern.charAt(pos[i]);
                    pos[i]++;
                    if (c != '*') {
                        if (currentChar == null) {
                            currentChar = c;
                            result.append(c);
                        } else if (!currentChar.equals(c)) {
                            return false;
                        }
                        completed = false;
                    }
                }
            }

            if (completed) {
                break;
            }
        }

        StringBuilder suffix = new StringBuilder();
        String[] remainingPatterns = new String[n];
        for (int i = 0; i < n; i++) {
            remainingPatterns[i] = patterns[i].substring(pos[i]);
        }

        if (!processSuffix(remainingPatterns, n, suffix)) {
            return false;
        }

        result.append(suffix.reverse().toString());
        return true;
    }

    private boolean processSuffix(String[] patterns, int n, StringBuilder result) {
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = patterns[i].length() - 1;
        }

        while (true) {
            boolean completed = true;
            Character currentChar = null;

            for (int i = 0; i < n; i++) {
                String pattern = patterns[i];
                if (pos[i] >= 0) {
                    char c = pattern.charAt(pos[i]);
                    pos[i]--;
                    if (currentChar == null) {
                        currentChar = c;
                        result.append(c);
                    } else if (!currentChar.equals(c)) {
                        return false;
                    }
                    completed = false;
                }
            }

            if (completed) {
                break;
            }
        }

        return true;
    }
}