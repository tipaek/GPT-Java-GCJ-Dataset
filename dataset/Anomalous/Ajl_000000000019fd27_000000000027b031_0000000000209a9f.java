import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = sc.next();
            String result = buildPrimeString(input);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String buildPrimeString(String input) {
        int depth = 0;
        StringBuilder primeString = new StringBuilder();
        for (char ch : input.toCharArray()) {
            int currentDigit = ch - '0';
            while (depth < currentDigit) {
                primeString.append('(');
                depth++;
            }
            while (depth > currentDigit) {
                primeString.append(')');
                depth--;
            }
            primeString.append(currentDigit);
        }
        while (depth > 0) {
            primeString.append(')');
            depth--;
        }
        return primeString.toString();
    }
}