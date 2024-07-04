import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            String input = scanner.next();
            boolean isBinary = input.chars().allMatch(c -> c == '0' || c == '1');
            StringBuilder output = new StringBuilder();
            
            if (isBinary) {
                processBinaryString(input, output);
            } else {
                processNonBinaryString(input, output);
            }
            
            System.out.println("Case #" + caseNumber + ": " + output.toString());
        }
    }

    private static void processBinaryString(String input, StringBuilder output) {
        StringBuilder ones = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            
            if (currentChar == '0') {
                if (ones.length() != 0) {
                    output.append(ones).append(')');
                    ones.setLength(0);
                }
                output.append('0');
            } else {
                if (ones.length() == 0) {
                    output.append('(');
                }
                ones.append('1');
                if (i == input.length() - 1) {
                    output.append(ones).append(')');
                }
            }
        }
    }

    private static void processNonBinaryString(String input, StringBuilder output) {
        String openBrackets = "((((((((((";
        String closeBrackets = "))))))))))";
        int previousNum = 0;
        
        for (int i = 0; i < input.length(); i++) {
            int currentNum = Character.getNumericValue(input.charAt(i));
            
            if (i == 0) {
                output.append(openBrackets.substring(0, currentNum))
                      .append(currentNum)
                      .append(closeBrackets.substring(0, Math.abs(previousNum - currentNum)));
            } else {
                output.append(openBrackets.substring(0, Math.abs(previousNum - currentNum)))
                      .append(currentNum)
                      .append(closeBrackets.substring(0, Math.abs(previousNum - currentNum)));
            }
            
            previousNum = currentNum;
        }
    }
}