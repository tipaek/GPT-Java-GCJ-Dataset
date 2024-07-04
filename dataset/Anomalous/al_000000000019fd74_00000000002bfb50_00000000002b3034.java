import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();

            for (int i = 0; i < testCount; i++) {
                int count = scanner.nextInt();
                List<String> patterns = new ArrayList<>();
                for (int j = 0; j < count; j++) {
                    patterns.add(scanner.next());
                }
                String result = solve(patterns);
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
    }

    private static String solve(List<String> patterns) {
        int offset = 0;
        while (patterns.size() > 1) {
            char commonChar = '-';
            for (int i = patterns.size() - 1; i >= 0; i--) {
                String pattern = patterns.get(i);
                int index = pattern.length() - offset - 1;
                if (index < 1) {
                    if (patterns.size() == 1) {
                        break;
                    }
                    patterns.remove(i);
                    continue;
                }
                char currentChar = pattern.charAt(index);
                if (commonChar == '-') {
                    commonChar = currentChar;
                    continue;
                }
                if (commonChar != currentChar) {
                    return "*";
                }
            }
            offset++;
        }
        String longestPattern = patterns.get(0);
        return longestPattern.substring(1);
    }
}