import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numCases = scanner.nextInt();
            for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
                String input = scanner.next();
                int[] digits = new int[input.length()];
                
                for (int i = 0; i < input.length(); i++) {
                    digits[i] = Character.getNumericValue(input.charAt(i));
                }
                
                StringBuilder[] output = new StringBuilder[input.length()];
                for (int i = 0; i < input.length(); i++) {
                    output[i] = new StringBuilder();
                }
                
                for (int i = 0; i < input.length(); i++) {
                    while (digits[i] > 0) {
                        output[i].append('(');
                        
                        int endIndex = input.length() - 1;
                        for (int j = i; j < input.length(); j++) {
                            if (digits[j] <= 0) {
                                endIndex = j - 1;
                                break;
                            }
                            digits[j]--;
                        }
                        
                        output[endIndex].append(')');
                        digits[endIndex]--;
                        digits[i]--;
                    }
                }
                
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < input.length(); i++) {
                    result.append(output[i]).append(input.charAt(i));
                }
                
                System.out.printf("Case #%d: %s%n", caseIndex + 1, result.toString());
            }
        }
    }
}