import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int testCase = 0; testCase < t; testCase++) {
            String input = br.readLine();
            int length = input.length();
            int currentBraces = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int value = Character.getNumericValue(input.charAt(i));
                
                if (value == currentBraces) {
                    result.append(input.charAt(i));
                } else if (value > currentBraces) {
                    int difference = value - currentBraces;
                    result.append(repeatCharacter('(', difference)).append(input.charAt(i));
                    currentBraces += difference;
                } else {
                    int difference = currentBraces - value;
                    result.append(repeatCharacter(')', difference)).append(input.charAt(i));
                    currentBraces -= difference;
                }
            }
            
            if (currentBraces > 0) {
                result.append(repeatCharacter(')', currentBraces));
            }
            
            System.out.println(result);
        }
    }

    private static String repeatCharacter(char character, int times) {
        return String.join("", Collections.nCopies(times, String.valueOf(character)));
    }
}