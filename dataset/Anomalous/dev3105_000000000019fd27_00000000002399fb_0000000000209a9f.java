import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String number = sc.next();
            int currentBalance = 0;
            StringBuilder result = new StringBuilder();

            for (char digitChar : number.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);
                int balanceDifference = digit - currentBalance;

                if (balanceDifference > 0) {
                    result.append("(".repeat(balanceDifference));
                } else if (balanceDifference < 0) {
                    result.append(")".repeat(-balanceDifference));
                }

                result.append(digit);
                currentBalance = digit;
            }

            if (currentBalance > 0) {
                result.append(")".repeat(currentBalance));
            }

            System.out.println("Case #" + t + ": " + result);
        }

        sc.close();
    }
}