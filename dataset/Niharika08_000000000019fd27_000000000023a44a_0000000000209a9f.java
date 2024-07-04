import java.util.Scanner;

public class GCGNestingDepth {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        String testString;
        for (int i = 0; i < testCases; i++) {
            testString = s.next();
            System.out.println("Case #" + (i + 1) + ": " + getNestedString(testString));
        }
    }

    private static String getNestedString(String inputString) {
        int currentBrackets = 0;
        String returnString = "";
        int openingBraces = 0, closingBraces = 0;
        int currentDigit;
        int difference;
        for (int j = 0; j < inputString.length(); j++) {
            currentDigit = Integer.parseInt(String.valueOf(inputString.charAt(j)));
            difference = currentDigit - openingBraces;
            if (difference > 0) {
                while (difference > 0) {
                    returnString = returnString + "(";
                    difference = difference - 1;
                    openingBraces++;
                }
            } else {
                difference = openingBraces - currentDigit;
                while (difference > 0) {
                    returnString = returnString + ")";
                    difference = difference - 1;
                    openingBraces--;
                }
            }
            returnString = returnString + (inputString.charAt(j));
        }
        while (openingBraces > 0) {
            returnString = returnString + ")";
            openingBraces--;
        }
        return returnString;
    }

}
