import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            int numPatterns = scanner.nextInt();
            scanner.nextLine();
            String[] patterns = new String[numPatterns];
            String finalPattern = "";
            
            for (int j = 0; j < numPatterns; j++) {
                patterns[j] = scanner.nextLine();
                if (patterns[j].startsWith(" ") || patterns[j].endsWith(" ")) {
                    throw new RuntimeException("oops");
                }
            }
            
            String longestEndingPattern = "";
            for (int j = 0; j < numPatterns; j++) {
                String ending = patterns[j].substring(patterns[j].indexOf("*") + 1);
                if (ending.length() > longestEndingPattern.length()) {
                    if (ending.contains(longestEndingPattern)) {
                        longestEndingPattern = ending;
                    } else {
                        finalPattern = "*";
                        break;
                    }
                } else {
                    if (!longestEndingPattern.contains(ending)) {
                        finalPattern = "*";
                    }
                }
            }
            
            if (!finalPattern.equals("*")) {
                finalPattern = longestEndingPattern;
            }
            
            System.out.println("Case #" + i + ": " + finalPattern);
        }
        
        scanner.close();
    }
}