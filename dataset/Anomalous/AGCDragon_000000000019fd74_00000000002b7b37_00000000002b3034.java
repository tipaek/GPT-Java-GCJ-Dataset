import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int patternsCount = scanner.nextInt();
            String startPattern = "";
            String endPattern = "";
            List<String> middlePatterns = new ArrayList<>();
            boolean isValid = true;
            String result = "";

            for (int i = 0; i < patternsCount; i++) {
                String pattern = scanner.next();
                int firstAsteriskIndex = pattern.indexOf('*');
                int lastAsteriskIndex = pattern.lastIndexOf('*');
                int patternLength = pattern.length();
                
                StringBuilder tempMiddle = new StringBuilder();
                boolean isMiddle = false;

                for (int j = 0; j < lastAsteriskIndex; j++) {
                    char currentChar = pattern.charAt(j);
                    if (currentChar == '*') {
                        if (tempMiddle.length() > 0) {
                            middlePatterns.add(tempMiddle.toString());
                        }
                        tempMiddle.setLength(0);
                        isMiddle = true;
                    } else {
                        if (isMiddle) {
                            tempMiddle.append(currentChar);
                        } else {
                            if (startPattern.length() < j + 1) {
                                startPattern += currentChar;
                            } else if (startPattern.charAt(j) != currentChar) {
                                result = "*";
                                isValid = false;
                                break;
                            }
                        }
                    }
                }

                for (int j = patternLength - 1; j >= lastAsteriskIndex; j--) {
                    char currentChar = pattern.charAt(j);
                    if (currentChar == '*') {
                        break;
                    } else {
                        int endPatternIndex = patternLength - 1 - j;
                        if (endPattern.length() < endPatternIndex + 1) {
                            endPattern = currentChar + endPattern;
                        } else if (endPattern.charAt(endPattern.length() - 1 - endPatternIndex) != currentChar) {
                            result = "*";
                            isValid = false;
                            break;
                        }
                    }
                }
            }

            if (isValid) {
                StringBuilder finalAnswer = new StringBuilder(startPattern);
                for (String middle : middlePatterns) {
                    finalAnswer.append(middle);
                }
                finalAnswer.append(endPattern);
                result = finalAnswer.toString();
            }

            System.out.println("Case #" + t + ": " + result);
        }

        scanner.close();
    }
}