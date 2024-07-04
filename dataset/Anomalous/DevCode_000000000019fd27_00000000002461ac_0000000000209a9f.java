import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            String s = sc.next();
            char[] myArray = s.toCharArray();
            StringBuilder newString = new StringBuilder();

            // Add opening parentheses for the first character
            int firstDigit = Character.getNumericValue(myArray[0]);
            for (int k = 0; k < firstDigit; k++) {
                newString.append("(");
            }
            newString.append(myArray[0]);

            // Process the rest of the characters
            for (int i = 1; i < s.length(); i++) {
                int currentDigit = Character.getNumericValue(myArray[i]);
                int previousDigit = Character.getNumericValue(myArray[i - 1]);

                if (currentDigit > previousDigit) {
                    for (int k = 0; k < currentDigit - previousDigit; k++) {
                        newString.append("(");
                    }
                } else if (currentDigit < previousDigit) {
                    for (int k = 0; k < previousDigit - currentDigit; k++) {
                        newString.append(")");
                    }
                }

                newString.append(myArray[i]);
            }

            // Add closing parentheses for the last character
            for (int z = 0; z < firstDigit; z++) {
                newString.append(")");
            }

            System.out.println("Case #" + t + ": " + newString);
        }
    }
}