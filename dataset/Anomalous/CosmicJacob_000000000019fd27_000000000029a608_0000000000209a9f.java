import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = sc.nextInt();
        
        for (int i = 0; i < numCases; i++) {
            String inputString = sc.next();
            String primeString = nestString(0, inputString);
            System.out.println(primeString);
        }
        
        sc.close();
    }

    private static String nestString(int depth, String inputString) {
        if (inputString.isEmpty()) {
            return "";
        }

        int currentDigit = inputString.charAt(0) - '0';
        String remainingString = inputString.substring(1);
        StringBuilder result = new StringBuilder();

        if (currentDigit > depth) {
            result.append("(".repeat(currentDigit - depth));
            result.append(currentDigit);
            result.append(nestString(currentDigit, remainingString));
        } else if (currentDigit < depth) {
            result.append(")".repeat(depth - currentDigit));
            result.append(currentDigit);
            result.append(nestString(currentDigit, remainingString));
        } else {
            result.append(currentDigit);
            result.append(nestString(depth, remainingString));
        }

        if (remainingString.isEmpty()) {
            result.append(")".repeat(currentDigit));
        }

        return result.toString();
    }
}