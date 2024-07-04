import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (n > 0) {
            int testCases = scanner.nextInt();
            String[] patterns = new String[testCases];

            for (int i = 0; i < testCases; i++) {
                patterns[i] = scanner.next();
            }

            Arrays.sort(patterns, Comparator.comparingInt(String::length));

            String referencePattern = patterns[testCases - 1];
            String result = processPatterns(referencePattern, patterns);

            System.out.println(result);
            n--;
        }
    }

    private static String processPatterns(String referencePattern, String[] patterns) {
        String basePattern = referencePattern.replace("*", "");
        int flag = 0;

        for (String pattern : patterns) {
            String[] splitPattern = pattern.split("\\*", 2);
            String prefix = splitPattern[0];
            String suffix = splitPattern.length > 1 ? splitPattern[1] : "";

            if (!basePattern.startsWith(prefix) || !basePattern.endsWith(suffix)) {
                flag = 1;
                break;
            }
        }

        return flag == 0 ? basePattern : "*";
    }
}