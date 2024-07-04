
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int noOfTestCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= noOfTestCases; ++testCase) {
            String inputText = in.next();
            int currentDigit = 0, previousDigit = 0;
            StringBuffer outputText = new StringBuffer();
            for (int index = 0; index < inputText.length(); index++) {
                char digit = inputText.charAt(index);
                currentDigit = digit - '0';
                int diffDept  = previousDigit - currentDigit;
                if (diffDept < 0) {
                    for (int leftPar = 0; leftPar < (-diffDept); leftPar++) {
                        outputText.append('(');
                    }
                } else  {
                    for (int rightPar = 0; rightPar < diffDept; rightPar++) {
                        outputText.append(')');
                    }
                }
                outputText.append(digit);
                previousDigit = currentDigit;
            }
            if (currentDigit > 0) {
                for (int rightPar = 0; rightPar < currentDigit; rightPar++) {
                    outputText.append(')');
                }
            }
            System.out.println("Case #" + testCase + ": " + outputText.toString());
        }
    }
}
