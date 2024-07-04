import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Map<String, String> digitToLetter = new HashMap<>();
        Map<String, String> letterToDigit = new HashMap<>();
        
        // Initialize digit to letter and letter to digit mappings
        for (int i = 1; i <= 9; i++) {
            char letter = (char) ('A' + i - 1);
            digitToLetter.put(String.valueOf(i), String.valueOf(letter));
            letterToDigit.put(String.valueOf(letter), String.valueOf(i));
        }

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < testCases; t++) {
            String inputLine = scanner.nextLine();
            String result = inputLine;
            int lineLength = inputLine.length();

            for (int digit = 1; digit <= 9; digit++) {
                String strDigit = String.valueOf(digit);
                for (int i = lineLength - 1; i >= 0; i--) {
                    String currentPattern = generateString(lineLength + 1, strDigit);
                    String replacementPattern = generateString(digit, "(") 
                                                + generateString(lineLength + 1, digitToLetter.get(strDigit)) 
                                                + generateString(digit, ")");
                    result = result.replace(currentPattern, replacementPattern);
                }
                lineLength = inputLine.length();
            }

            // Replace letters back to digits
            for (Map.Entry<String, String> entry : letterToDigit.entrySet()) {
                result = result.replace(entry.getKey(), entry.getValue());
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String generateString(int length, String character) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}