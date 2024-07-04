import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(final String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = sc.nextInt();
        
        for (int i = 1; i <= numCases; i++) {
            String inputString = sc.next();
            String primeString = nestString(0, inputString);
            System.out.println("Case #" + i + ": " + primeString);
        }
        
        sc.close();
    }

    private static String nestString(int depth, String inputString) {
        if (inputString.isEmpty()) {
            return "";
        }

        int currentDigit = inputString.charAt(0) - '0';
        int nextDigit = inputString.length() > 1 ? inputString.charAt(1) - '0' : -1;
        StringBuilder result = new StringBuilder();

        if (currentDigit > depth) {
            result.append("(".repeat(currentDigit - depth));
            result.append(currentDigit);
            result.append(nestString(currentDigit, inputString.substring(1)));
        } else if (currentDigit < depth) {
            result.append(")".repeat(depth - currentDigit));
            result.append(currentDigit);
            result.append(nestString(currentDigit, inputString.substring(1)));
        } else {
            result.append(currentDigit);
            result.append(nestString(depth, inputString.substring(1)));
        }

        if (nextDigit < currentDigit) {
            result.append(")".repeat(currentDigit - nextDigit));
        }

        return result.toString();
    }
}