import java.util.Scanner;
import java.util.regex.Pattern;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            String matchedResult = "";

            for (int i = 0; i < n / 2; i++) {
                String patternStr = scanner.next().replace('*', '.*');
                String checkStr = scanner.next().replace('*', '.');
                if (Pattern.matches(patternStr, checkStr)) {
                    matchedResult = checkStr;
                }
            }

            if (matchedResult.isEmpty()) {
                result.append("Case #").append(caseNumber).append(": *\n");
            } else {
                result.append("Case #").append(caseNumber).append(": ")
                      .append(matchedResult.substring(1)).append("\n");
            }
        }

        System.out.print(result.toString());
        scanner.close();
    }
}