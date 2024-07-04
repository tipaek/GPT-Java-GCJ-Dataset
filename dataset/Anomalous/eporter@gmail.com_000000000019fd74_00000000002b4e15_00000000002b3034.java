import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private final Scanner in;

    public Solution(Scanner in) {
        this.in = in;
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }

    public static void run(Scanner scanner) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            new Solution(scanner).processTestCase(i);
        }
    }

    private void processTestCase(int caseNumber) {
        int n = in.nextInt();
        List<String> patterns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            patterns.add(in.next());
        }

        String prefix = "";
        String suffix = "";
        StringBuilder middle = new StringBuilder();
        boolean isPossible = true;

        for (String pattern : patterns) {
            int firstStar = pattern.indexOf("*");
            String currentPrefix = pattern.substring(0, firstStar);

            if (currentPrefix.length() < prefix.length()) {
                if (!prefix.startsWith(currentPrefix)) {
                    isPossible = false;
                    break;
                }
            } else {
                if (currentPrefix.startsWith(prefix)) {
                    prefix = currentPrefix;
                } else {
                    isPossible = false;
                    break;
                }
            }

            int lastStar = pattern.lastIndexOf("*");
            String currentSuffix = pattern.substring(lastStar + 1);

            if (currentSuffix.length() < suffix.length()) {
                if (!suffix.endsWith(currentSuffix)) {
                    isPossible = false;
                    break;
                }
            } else {
                if (currentSuffix.endsWith(suffix)) {
                    suffix = currentSuffix;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (firstStar != lastStar) {
                for (char c : pattern.substring(firstStar + 1, lastStar).toCharArray()) {
                    if (c != '*') {
                        middle.append(c);
                    }
                }
            }
        }

        String result = isPossible ? prefix + middle + suffix : "*";
        printResult(caseNumber, result);
    }

    private static void printResult(int caseNumber, String result) {
        System.out.printf("Case #%d: %s%n", caseNumber, result);
    }
}