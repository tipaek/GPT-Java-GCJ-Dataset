import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int patternCount = scanner.nextInt();
            scanner.nextLine();
            
            String[] patterns = new String[patternCount];
            for (int j = 0; j < patternCount; j++) {
                patterns[j] = scanner.nextLine();
                if (patterns[j].startsWith(" ") || patterns[j].endsWith(" ")) {
                    throw new RuntimeException("oops");
                }
            }

            String longestEndingPattern = "";
            boolean isValid = true;

            for (String pattern : patterns) {
                String ending = pattern.substring(pattern.indexOf("*") + 1);
                if (ending.length() > longestEndingPattern.length()) {
                    if (ending.contains(longestEndingPattern)) {
                        longestEndingPattern = ending;
                    } else {
                        isValid = false;
                        break;
                    }
                } else {
                    if (!longestEndingPattern.contains(ending)) {
                        isValid = false;
                        break;
                    }
                }
            }

            String solution = isValid ? longestEndingPattern : "*";
            System.out.println("Case #" + caseNumber + ": " + solution);
        }
        
        scanner.close();
    }
}