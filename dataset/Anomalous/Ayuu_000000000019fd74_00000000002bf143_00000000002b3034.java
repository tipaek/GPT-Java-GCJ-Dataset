import java.util.Scanner;
import java.util.regex.Pattern;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            String matchingString = "";

            for (int i = 0; i < n / 2; i++) {
                String patternString = "." + scanner.next();
                String inputString = "." + scanner.next();
                boolean isMatch = Pattern.matches(patternString, inputString);

                if (isMatch) {
                    matchingString = inputString;
                }
            }

            if (matchingString.isEmpty()) {
                result.append("Case #").append(caseNumber).append(": *\n");
            } else {
                String outputString = matchingString.substring(1);
                result.append("Case #").append(caseNumber).append(": ").append(outputString).append("\n");
            }
        }

        System.out.print(result.toString());
        scanner.close();
    }
}