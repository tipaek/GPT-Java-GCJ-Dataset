import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            String input = scanner.next();
            int length = input.length();
            int[] digits = new int[length];
            
            for (int i = 0; i < length; i++) {
                digits[i] = Character.getNumericValue(input.charAt(i));
            }
            
            StringBuilder[] output = new StringBuilder[length];
            for (int i = 0; i < length; i++) {
                output[i] = new StringBuilder();
            }
            
            for (int i = 0; i < length; i++) {
                while (digits[i] > 0) {
                    output[i].append("(");
                    
                    int endIndex = length - 1;
                    for (int j = i; j < length; j++) {
                        if (digits[j] <= 0) {
                            endIndex = j - 1;
                            break;
                        }
                        digits[j]--;
                    }
                    
                    output[endIndex].append(")");
                    digits[endIndex]--;
                }
            }
            
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < length; i++) {
                result.append(output[i]).append(input.charAt(i));
            }
            
            System.out.printf("Case #%d: %s%n", t + 1, result.toString());
        }
    }
}