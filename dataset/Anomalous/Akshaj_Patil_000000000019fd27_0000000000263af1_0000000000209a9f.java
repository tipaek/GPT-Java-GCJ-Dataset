import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int caseNo = 1; caseNo <= testCases; caseNo++) {
            String[] input = sc.nextLine().split("");
            int[] inputNumbers = new int[input.length];
            int[] countBraces = new int[input.length];
            String originalInput = String.join("", input);
            String answer = originalInput;

            // Convert input strings to integers
            for (int i = 0; i < input.length; i++) {
                inputNumbers[i] = Integer.parseInt(input[i]);
            }

            Arrays.sort(input);

            for (String digit : input) {
                int index = originalInput.indexOf(digit);
                int left = index, right = index;

                // Find the left boundary
                while (left > 0 && inputNumbers[left - 1] >= inputNumbers[index]) {
                    left--;
                }

                // Find the right boundary
                while (right < inputNumbers.length - 1 && inputNumbers[right + 1] >= inputNumbers[index]) {
                    right++;
                }

                originalInput = originalInput.replaceFirst(digit, ".");

                // Build the substring and update countBraces
                StringBuilder subStr = new StringBuilder();
                for (int j = left; j <= right; j++) {
                    if (inputNumbers[index] != 0) {
                        countBraces[j]++;
                    }
                    subStr.append(inputNumbers[j]);
                }

                if (inputNumbers[index] != 0) {
                    answer = answer.replaceFirst(subStr.toString(), "(" + subStr + ")");
                    if (countBraces[index] < inputNumbers[index]) {
                        String sstr = subStr.toString();
                        int ct = inputNumbers[index] - countBraces[index];
                        for (int k = 0; k < ct; k++) {
                            sstr = "(" + sstr + ")";
                        }
                        answer = answer.replaceFirst(subStr.toString(), sstr);
                        for (int k = left; k <= right; k++) {
                            countBraces[k] = inputNumbers[index];
                        }
                    }
                }
                answer = answer.replaceFirst(digit, ".");
            }

            // Replace dots with original digits
            StringBuilder finalAnswer = new StringBuilder();
            int temp = 0;
            for (char ch : answer.toCharArray()) {
                if (ch == '.') {
                    finalAnswer.append(inputNumbers[temp]);
                    temp++;
                } else {
                    finalAnswer.append(ch);
                }
            }

            System.out.println("Case #" + caseNo + ": " + finalAnswer);
        }
    }
}