import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        
        for (int i = 1; i <= numberOfCases; i++) {
            String input = scanner.next();
            ArrayList<String> substrings = getSubstrings(input);
            String result = formatOutput(substrings);
            System.out.println("Case #" + i + ": " + result);
        }
        
        scanner.close();
    }

    private static ArrayList<String> getSubstrings(String input) {
        ArrayList<String> substrings = new ArrayList<>();
        
        while (!input.isEmpty()) {
            char currentChar = input.charAt(0);
            int length = 1;
            
            while (length < input.length() && input.charAt(length) == currentChar) {
                length++;
            }
            
            String substring = input.substring(0, length);
            substrings.add(substring);
            input = input.substring(length);
        }
        
        return substrings;
    }

    private static String formatOutput(ArrayList<String> substrings) {
        StringBuilder formattedOutput = new StringBuilder();
        
        for (String substring : substrings) {
            if (substring.charAt(0) == '1') {
                formattedOutput.append("(").append(substring).append(")");
            } else {
                formattedOutput.append(substring);
            }
        }
        
        return formattedOutput.toString();
    }
}