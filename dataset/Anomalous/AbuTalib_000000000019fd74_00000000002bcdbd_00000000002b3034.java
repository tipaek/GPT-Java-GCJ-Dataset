import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numberOfLines = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline
            
            StringBuilder startPattern = new StringBuilder();
            StringBuilder endPattern = new StringBuilder();
            StringBuilder middlePattern = new StringBuilder();
            boolean isInvalid = false;
            
            for (int lineIndex = 0; lineIndex < numberOfLines; lineIndex++) {
                char[] line = scanner.nextLine().toCharArray();
                int startAsteriskIndex = 0, endAsteriskIndex = 0;
                
                // Process the start part before the first asterisk
                for (int charIndex = 0; charIndex < line.length; charIndex++) {
                    if (line[charIndex] == '*') {
                        startAsteriskIndex = charIndex;
                        break;
                    }
                    if (charIndex == startPattern.length()) {
                        startPattern.append(line[charIndex]);
                    } else if (startPattern.charAt(charIndex) != line[charIndex]) {
                        isInvalid = true;
                        break;
                    }
                }
                
                // Process the end part after the last asterisk
                if (!isInvalid) {
                    for (int charIndex = line.length - 1; charIndex >= 0; charIndex--) {
                        int reversedIndex = line.length - 1 - charIndex;
                        if (line[charIndex] == '*') {
                            endAsteriskIndex = charIndex;
                            break;
                        }
                        if (reversedIndex == endPattern.length()) {
                            endPattern.append(line[charIndex]);
                        } else if (endPattern.charAt(reversedIndex) != line[charIndex]) {
                            isInvalid = true;
                            break;
                        }
                    }
                }
                
                // Collect the middle part between the asterisks
                if (!isInvalid) {
                    for (int charIndex = startAsteriskIndex; charIndex < endAsteriskIndex; charIndex++) {
                        if (line[charIndex] != '*') {
                            middlePattern.append(line[charIndex]);
                        }
                    }
                }
            }
            
            System.out.printf("Case #%d: ", caseNumber);
            if (!isInvalid) {
                System.out.println(startPattern.toString() + middlePattern + endPattern.reverse());
            } else {
                System.out.println("*");
            }
        }
    }
}