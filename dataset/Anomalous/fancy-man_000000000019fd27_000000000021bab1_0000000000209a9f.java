import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            char[] inputLine = scanner.nextLine().toCharArray();
            int length = inputLine.length;

            byte[] digits = new byte[length];
            for (int i = 0; i < length; i++) {
                digits[i] = (byte) Character.digit(inputLine[i], 10);
            }

            StringBuilder result = new StringBuilder();
            int currentLevel = 0;

            for (int i = 0; i < length; i++) {
                int difference = digits[i] - currentLevel;
                
                while (difference > 0) {
                    result.append('(');
                    currentLevel++;
                    difference--;
                }
                
                while (difference < 0) {
                    result.append(')');
                    currentLevel--;
                    difference++;
                }
                
                result.append(digits[i]);
            }

            while (currentLevel > 0) {
                result.append(')');
                currentLevel--;
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }

        scanner.close();
    }
}