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

            String longest = "";

            for (String string : patterns) {
                if (string.length() > longest.length()) longest = string;
            }

            boolean pass = true;

            for (String string : patterns) {
                String word = string.substring(1);
                String base = longest.substring(1);
                if (!base.endsWith(word)) {
                    pass = false;
                    break;
                }
            }

            if (pass) {
                System.out.println("Case #" + caseNum + ": " + longest.substring(1));
            } else {
                System.out.println("Case #" + caseNum + ": *");
            }
        }
    }
}
