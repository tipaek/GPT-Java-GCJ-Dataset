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
            return ")".repeat(depth);
        }

        int currentDigit = inputString.charAt(0) - '0';
        String restString = inputString.substring(1);

        if (currentDigit > depth) {
            return "(".repeat(currentDigit - depth) + currentDigit + nestString(currentDigit, restString);
        } else if (currentDigit < depth) {
            return ")".repeat(depth - currentDigit) + currentDigit + nestString(currentDigit, restString);
        } else {
            return currentDigit + nestString(depth, restString);
        }
    }
}