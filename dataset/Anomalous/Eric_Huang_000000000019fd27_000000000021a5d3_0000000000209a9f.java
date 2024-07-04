import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();

        for (int i = 0; i < numCases; i++) {
            String input = scanner.next();
            int length = input.length();
            int[] digits = new int[length];
            StringBuilder[] openBrackets = new StringBuilder[length];
            StringBuilder[] closeBrackets = new StringBuilder[length];

            for (int j = 0; j < length; j++) {
                digits[j] = Character.getNumericValue(input.charAt(j));
                openBrackets[j] = new StringBuilder();
                closeBrackets[j] = new StringBuilder();
            }

            for (int j = 0; j < length; j++) {
                while (digits[j] > 0) {
                    openBrackets[j].append("(");
                    int endIndex = length - 1;

                    for (int k = j; k < length; k++) {
                        if (digits[k] <= 0) {
                            endIndex = k - 1;
                            break;
                        }
                        digits[k]--;
                    }

                    closeBrackets[endIndex].append(")");
                    digits[endIndex]--;
                    digits[j]--;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < length; j++) {
                result.append(openBrackets[j]).append(input.charAt(j)).append(closeBrackets[j]);
            }

            System.out.println(result);
        }
    }
}