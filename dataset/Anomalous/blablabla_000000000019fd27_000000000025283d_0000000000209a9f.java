import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder formattedOutput = new StringBuilder();
            char[] inputChars = input.toCharArray();

            char previousChar = 'x';
            for (int index = 0; index < inputChars.length; index++) {
                if (inputChars[index] == '1' && previousChar != '1') {
                    formattedOutput.append('(');
                } else if (inputChars[index] == '0' && previousChar == '1') {
                    formattedOutput.append(')');
                }

                formattedOutput.append(inputChars[index]);

                if (index == inputChars.length - 1 && inputChars[index] == '1') {
                    formattedOutput.append(')');
                }

                previousChar = inputChars[index];
            }
            System.out.println("Case #" + caseNumber + ": " + formattedOutput);
        }
    }
}