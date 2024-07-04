import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numPatterns = scanner.nextInt();
            String[] patterns = new String[numPatterns];

            for (int i = 0; i < patterns.length; i++) {
                patterns[i] = scanner.next();
            }

            String longestPattern = "";

            for (String string : patterns) {
                if (string.length() > longestPattern.length()) {
                    longestPattern = string;
                }
            }

            boolean pass = true;

            for (String string : patterns) {
                if (!longestPattern.contains(string.substring(1))) {

                    pass = false;
                    break;
                }
            }

            if (pass) {
                System.out.println("Case #" + caseNum + ": " + longestPattern.substring(1));
            } else {
                System.out.println("Case #" + caseNum + ": *");
            }
        }
    }
}
