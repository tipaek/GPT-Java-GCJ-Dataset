import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int t = 1; t <= testCases; t++) {
            String inputLine = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int previousDigit = 0;
            
            for (int i = 0; i < inputLine.length(); i++) {
                int currentDigit = Character.getNumericValue(inputLine.charAt(i));
                int difference = currentDigit - previousDigit;
                
                if (difference > 0) {
                    output.append("(".repeat(difference));
                } else if (difference < 0) {
                    output.append(")".repeat(-difference));
                }
                
                output.append(currentDigit);
                previousDigit = currentDigit;
            }
            
            output.append(")".repeat(previousDigit));
            
            System.out.printf("Case #%d: %s%n", t, output.toString());
        }
        
        scanner.close();
    }
}