import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String numberString = scanner.next();
            int length = numberString.length();
            int[] digits = new int[length];

            for (int j = 0; j < length; j++) {
                digits[j] = Character.getNumericValue(numberString.charAt(j));
            }

            StringBuilder[] output = new StringBuilder[length];
            for (int j = 0; j < length; j++) {
                output[j] = new StringBuilder();
            }

            for (int j = 0; j < length; j++) {
                while (digits[j] > 0) {
                    output[j].append('(');

                    int endIndex = length - 1;
                    for (int k = j; k < length; k++) {
                        if (digits[k] <= 0) {
                            endIndex = k - 1;
                            break;
                        }
                        digits[k]--;
                    }

                    output[endIndex].append(')');
                    digits[endIndex]--;
                    digits[j]--;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < length; j++) {
                result.append(output[j]).append(numberString.charAt(j));
            }

            System.out.printf("Case #%d: %s%n", i + 1, result.toString());
        }
    }
}